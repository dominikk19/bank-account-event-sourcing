package pl.dkiszka.bankaccount.application.app

import pl.dkiszka.bankaccount.application.app.dto.CreateAccountDto
import pl.dkiszka.bankaccount.application.app.dto.DepositDto
import pl.dkiszka.bankaccount.application.app.dto.TransferDto
import pl.dkiszka.bankaccount.application.domain.Account
import pl.dkiszka.bankaccount.application.domain.AccountRepository
import pl.dkiszka.bankaccount.application.domain.AggregateUuid
import java.math.BigDecimal
import java.util.*

/**
 * @author Dominik Kiszka {dominikk19}
 * @project application
 * @date 31.01.2021
 */
class AccountService(
    private val aggregateService: AggregateService,
    private val accountRepository: AccountRepository
) {
    fun create(createAccountDto: CreateAccountDto) {
        val account = Account.create(createAccountDto.ownerName, createAccountDto.name)
        aggregateService.store(account)
    }

    fun deposit(depositDto: DepositDto) {
        val account = findAccountByUuid(UUID.fromString(depositDto.aggregateUuid))
        account.deposit(BigDecimal(depositDto.amount))
        aggregateService.store(account)
    }

    fun transfer(transferDto: TransferDto) {
        val accountFrom = findAccountByUuid(UUID.fromString(transferDto.aggregateUuidFrom))
        val accountTo = findAccountByUuid(UUID.fromString(transferDto.aggregateUuidTo))
        accountFrom.withdraw(BigDecimal(transferDto.amount))
        accountTo.deposit(BigDecimal(transferDto.amount))
        aggregateService.store(accountFrom)
        aggregateService.store(accountTo)

    }

    private fun findAccountByUuid(aggregateUuid: AggregateUuid): Account {
        return accountRepository.findByAggregateUuid(aggregateUuid)
            ?: throw AggregateNotFoundException("Account uuid: ${aggregateUuid} not found")
    }
}
