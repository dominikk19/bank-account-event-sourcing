package pl.dkiszka.bankaccount.application.domain

import java.util.*


/**
 * @author Dominik Kiszka {dominikk19}
 * @project application
 * @date 26.01.2021
 */

typealias AggregateUuid = UUID

abstract class AggregateRoot(val aggregateUuid: AggregateUuid) {
    val pendingEvents = ArrayList<Event>()
}




