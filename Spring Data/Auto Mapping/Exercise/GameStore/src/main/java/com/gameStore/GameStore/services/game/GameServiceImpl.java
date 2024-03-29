package com.gameStore.GameStore.services.game;

import com.gameStore.GameStore.models.dto.GameDetailsDto;
import com.gameStore.GameStore.models.dto.GameEditDto;
import com.gameStore.GameStore.models.dto.GameNameAndPriceDto;
import com.gameStore.GameStore.models.dto.GameRegisterDto;
import com.gameStore.GameStore.models.entities.Game;
import com.gameStore.GameStore.repositories.GameRepository;
import com.gameStore.GameStore.services.user.UserService;
import com.gameStore.GameStore.util.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameServiceImpl implements GameService{

    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final ValidationUtil validationUtil;

    public GameServiceImpl(GameRepository gameRepository, ModelMapper modelMapper, UserService userService, ValidationUtil validationUtil) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.validationUtil = validationUtil;
    }

    @Override
    public void addGame(GameRegisterDto gameRegisterDto) {

        if (userService.getLoggedInUser() == null) {
            System.out.println("Not logged in user");
            return;
        }

        if(!userService.getLoggedInUser().getAdministrator()) {
            System.out.println("Only administrator can add games");
            return;
        }

        Set<ConstraintViolation<GameRegisterDto>> violation = validationUtil.violation(gameRegisterDto);

        if (!violation.isEmpty()) {
            violation.stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        Game game = modelMapper.map(gameRegisterDto, Game.class);

        gameRepository.save(game);

        System.out.println("Added " + game.getTitle());
    }

    @Override
    public void editGame(String[] commands) {
        if (userService.getLoggedInUser() == null) {
            System.out.println("Not logged in user");
            return;
        }

        if(!userService.getLoggedInUser().getAdministrator()) {
            System.out.println("Only administrator can edit games");
            return;
        }

        Optional<Game> gameToEdit = gameRepository.findById(Long.parseLong(commands[1]));

        if (gameToEdit.isEmpty()) {
            System.out.println("Game not found");
            return;
        }

        Map<String, String > fieldsToEdit = new HashMap<>();

        for (int i = 2; i < commands.length; i++) {
            String[] fieldAndValue = commands[i].split("=");
            fieldsToEdit.put(fieldAndValue[0], fieldAndValue[1]);
        }

        GameEditDto gameEditDto = modelMapper.map(gameToEdit.get(), GameEditDto.class);

        gameEditDto.editFields(fieldsToEdit);

        Game gameToSave = modelMapper.map(gameEditDto, Game.class);

        gameRepository.save(gameToSave);
        System.out.println("Edited " + gameToSave.getTitle());
    }

    @Override
    public void deleteGame(long id) {

        if (userService.getLoggedInUser() == null) {
            System.out.println("Not logged in user");
            return;
        }

        if(!userService.getLoggedInUser().getAdministrator()) {
            System.out.println("Only administrator can delete games");
            return;
        }

        Optional<Game> gameToDelete = gameRepository.findById(id);

        if (gameToDelete.isEmpty()) {
            System.out.println("Game not found");
            return;
        }

        gameRepository.delete(gameToDelete.get());

        System.out.println("Deleted " + gameToDelete.get().getTitle());
    }

    @Override
    public void showAllGames() {
        List<Game> games = gameRepository.findAll();

        if(games.isEmpty()) {
            System.out.println("Not found games");
            return;
        }

        List<GameNameAndPriceDto> gameToShow = new ArrayList<>();

        games.forEach(g -> gameToShow.add(modelMapper.map(g,GameNameAndPriceDto.class)));

        gameToShow.forEach(System.out::println);
    }

    @Override
    public void showGameDetails(String title) {
        Optional<Game> game = gameRepository.findByTitle(title);

        if (game.isEmpty()) {
            System.out.println("Game not found");
            return;
        }

        GameDetailsDto gameDetailsDto = modelMapper.map(game, GameDetailsDto.class);

        System.out.println(gameDetailsDto);
    }
}
