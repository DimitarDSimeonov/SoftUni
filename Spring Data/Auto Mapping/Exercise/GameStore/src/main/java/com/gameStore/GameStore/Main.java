package com.gameStore.GameStore;

import com.gameStore.GameStore.models.dto.UserLoginDto;
import com.gameStore.GameStore.models.dto.UserRegisterDto;
import com.gameStore.GameStore.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Main implements CommandLineRunner {

    private final Scanner scanner;
    private UserService userService;

    @Autowired
    public Main(UserService userService) {
        this.userService = userService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {

        while (true) {

            System.out.println("Enter commands:");

            String[] commands = scanner.nextLine().split("\\|");

            switch (commands[0]){
                case "RegisterUser" -> this.userService
                        .registerUser(new UserRegisterDto(commands[1], commands[2], commands[3], commands[4]));

                case "LoginUser" -> this.userService
                        .loginUser(new UserLoginDto(commands[1], commands[2]));

                case "Logout" -> this.userService.logout();

                //TODO: Add more methods!!!
            }

        }
    }
}
