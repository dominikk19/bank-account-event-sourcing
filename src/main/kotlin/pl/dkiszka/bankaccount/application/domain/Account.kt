package pl.dkiszka.bankaccount.application.domain

import pl.dkiszka.bankaccount.application.app.InsufficientAmountException
import java.math.BigDecimal
import java.util.*

/**
 * @author Dominik Kiszka {dominikk19}
 * @project application
 * @date 26.01.2021
 */
class Account(
    aggregateUuid: AggregateUuid,
    private val ownerName: String,
    private val name: String,
    private var amount: BigDecimal
) : AggregateRoot(aggregateUuid) {


    companion object {
        fun create(ownerName: String, name: String): Account {
            val account = Account(UUID.randomUUID(), ownerName, name, BigDecimal.ZERO)
            account.pendingEvents.add(AccountCreatedEvent(ownerName, name))
            return account
        }
    }

    fun deposit(amount: BigDecimal) {
        pendingEvents.add(DepositCreatedEvent(this.aggregateUuid, amount))
        this.amount = this.amount.add(amount)
    }

    fun withdraw(amount: BigDecimal) {
        if (this.amount < amount) {
            throw InsufficientAmountException("The invoice amount is insufficient")
        }
        this.pendingEvents.add(WithdrawCreatedEvent(this.aggregateUuid, amount))
        this.amount = this.amount.subtract(amount)
    }
}


