package com.gameStore.GameStore;

import com.gameStore.GameStore.models.dto.GameRegisterDto;
import com.gameStore.GameStore.models.dto.UserLoginDto;
import com.gameStore.GameStore.models.dto.UserRegisterDto;
import com.gameStore.GameStore.services.game.GameService;
import com.gameStore.GameStore.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Component
public class Main implements CommandLineRunner {

    private final Scanner scanner;
    private final UserService userService;
    private final GameService gameService;

    @Autowired
    public Main(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
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

                case "AddGame" -> this.gameService
                        .addGame(new GameRegisterDto(commands[1],
                                new BigDecimal(commands[2]),
                                Double.parseDouble(commands[3]),
                                        commands[4],
                                        commands[5],
                                        commands[6],
                                        LocalDate.parse(commands[7], DateTimeFormatter.ofPattern("dd-MM-yyyy"))));

                case "EditGame" -> this.gameService
                        .editGame(commands);

                case "DeleteGame" -> this.gameService.deleteGame(Long.parseLong(commands[1]));

                case "AllGames" -> this.gameService.showAllGames();

                case "DetailGame" -> this.gameService.showGameDetails(commands[1]);

                //TODO: Shopping cart!!!
            }

        }
    }
}
