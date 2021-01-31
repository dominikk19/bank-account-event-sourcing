package pl.dkiszka.bankaccount.application.domain

/**
 * @author Dominik Kiszka {dominikk19}
 * @project application
 * @date 31.01.2021
 */
interface DomainEventStoreRepository {
    fun findEventsByAggregateUuid(aggregateUuid: AggregateUuid): List<Event>
    fun save(event: Event)
}
