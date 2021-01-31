package pl.dkiszka.bankaccount.application.app.dto

/**
 * @author Dominik Kiszka {dominikk19}
 * @project application
 * @date 31.01.2021
 */
data class DepositDto(
    val aggregateUuid: String,
    val amount: String
)
