package pl.dkiszka.bankaccount.application.adapters

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author Dominik Kiszka {dominikk19}
 * @project application
 * @date 31.01.2021
 */
@RestController
@RequestMapping("/account")
class AccountController(
    //private val accountService : AccountService
    ) {


//    @PostMapping
//    fun create(@RequestBody createAccountDto : CreateAccountDto){
//        accountService.create(createAccountDto);
//    }
//
//    @PostMapping("/deposit")
//    fun deposit(@RequestBody depositDto: DepositDto){
//        accountService.deposit(depositDto)
//    }
//
//    @PostMapping("/transfer")
//    fun transfer(@RequestBody transferDto: TransferDto){
//        accountService.transfer(transferDto)
//    }
}
