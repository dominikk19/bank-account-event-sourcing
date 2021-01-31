package pl.dkiszka.bankaccount.application.adapters

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import pl.dkiszka.bankaccount.application.app.AccountService

/**
 * @author Dominik Kiszka {dominikk19}
 * @project application
 * @date 31.01.2021
 */
@Configuration
class AccountConfiguration {

    //todo
    @Bean
    fun accountService(): AccountService = AccountService();



}
