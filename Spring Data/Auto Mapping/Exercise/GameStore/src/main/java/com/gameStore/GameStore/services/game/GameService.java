package com.gameStore.GameStore.services.game;

import com.gameStore.GameStore.models.dto.GameRegisterDto;

public interface GameService {

    void addGame(GameRegisterDto gameRegisterDto);

    void editGame(String[] commands);

    void deleteGame(long id);
}
