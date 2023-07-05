package com.lab;

import com.lab.entities.Account;
import com.lab.entities.User;
import com.lab.services.AccountService;
import com.lab.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final AccountService accountService;
    private final UserService userService;

    @Autowired
    public ConsoleRunner(AccountService accountService, UserService userService) {
        this.accountService =accountService;
        this.userService = userService;
    }
    @Override
    public void run(String... args) throws Exception {

//        User user = new User("pesho" , 20);
//        userService.registerUser(user);

//        userService.printUserAge(1l);
//        accountService.depositMoney(new BigDecimal(20000), 1l);
//        accountService.withdrawMoney(new BigDecimal(20000), 1l);
    }
}
