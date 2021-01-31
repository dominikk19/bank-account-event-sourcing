package pl.dkiszka.bankaccount.application.domain

/**
 * @author Dominik Kiszka {dominikk19}
 * @project application
 * @date 31.01.2021
 */
interface AccountRepository {
    fun findByAggregateUuid(aggregateUuid: AggregateUuid) : Account?
}
