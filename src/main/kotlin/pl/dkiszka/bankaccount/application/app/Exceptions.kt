package pl.dkiszka.bankaccount.application.app

/**
 * @author Dominik Kiszka {dominikk19}
 * @project application
 * @date 31.01.2021
 */
class AggregateNotFoundException(msg: String) : RuntimeException(msg)


class InsufficientAmountException(msg: String) : RuntimeException(msg)
