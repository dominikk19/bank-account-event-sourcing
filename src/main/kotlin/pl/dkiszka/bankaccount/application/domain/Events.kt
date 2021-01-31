package pl.dkiszka.bankaccount.application.domain

import java.math.BigDecimal
import java.time.Instant
import java.util.*

abstract class Event(var aggregateUuid: AggregateUuid) {

    val eventUuid: UUID = UUID.randomUUID();
    val eventTime: Instant = Instant.now()

}

class AccountCreatedEvent(
    val ownerName: String,
    val accountName: String
) : Event(UUID.randomUUID())


class DepositCreatedEvent(
    aggregateUuid: AggregateUuid,
    val amount: BigDecimal
) : Event(aggregateUuid)


class WithdrawCreatedEvent(
    aggregateUuid: AggregateUuid,
    val amount: BigDecimal
) : Event(aggregateUuid)
