package pl.dkiszka.bankaccount.application.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigDecimal

/**
 * @author Dominik Kiszka {dominikk19}
 * @project application
 * @date 31.01.2021
 */
internal class AccountTest {

    private val OWNER_NAME = "John"
    private val NAME = "first account"


    @Test
    fun `when given owner name and name then account should be created`() {
        val actualAccount = Account.create(OWNER_NAME, NAME)

        Assertions.assertThat(actualAccount)
            .hasFieldOrPropertyWithValue("ownerName", OWNER_NAME)
            .hasFieldOrPropertyWithValue("name", NAME)
    }


    @Test
    fun `when deposit added then amount is 100 and one event is waiting`() {
        val actualAccount = Account.create(OWNER_NAME, NAME)
        actualAccount.deposit(BigDecimal(100));

        Assertions.assertThat(actualAccount)
            .hasFieldOrPropertyWithValue("amount", BigDecimal(100))
            .extracting("pendingEvents")
            .satisfies {
                if (it is ArrayList<*>) {
                    Assertions.assertThat(it.size).isEqualTo(2)
                }
            }
    }

    @Test
    fun `when withdraw added then WithdrawCreatedEvent should be included in pending events and amount should be 50`() {
        val actualAccount = Account.create(OWNER_NAME, NAME)
        actualAccount.deposit(BigDecimal(100));
        actualAccount.withdraw(BigDecimal(50))

        Assertions.assertThat(actualAccount)
            .hasFieldOrPropertyWithValue("amount", BigDecimal(50))
            .extracting("pendingEvents")
            .satisfies {
                if (it is ArrayList<*>) {
                    Assertions.assertThat(it.filterIsInstance<WithdrawCreatedEvent>().size).isEqualTo(1)
                }
            }
    }
}
