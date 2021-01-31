package pl.dkiszka.bankaccount.application.app

import pl.dkiszka.bankaccount.application.domain.AggregateRoot
import pl.dkiszka.bankaccount.application.domain.DomainEventPublisher
import pl.dkiszka.bankaccount.application.domain.DomainEventStoreRepository

/**
 * @author Dominik Kiszka {dominikk19}
 * @project application
 * @date 31.01.2021
 */
class AggregateService(
    private val domainEventPublisher: DomainEventPublisher,
    private val domainEventStoreRepository: DomainEventStoreRepository
) {
    fun store(aggregate: AggregateRoot) {
        aggregate.pendingEvents
            .forEach {
                domainEventStoreRepository.save(it)
                domainEventPublisher.publishEvent(it)
            }
        aggregate.pendingEvents.clear()
    }

}
