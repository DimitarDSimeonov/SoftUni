package viceCity.core;

import viceCity.common.ConstantMessages;
import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.GunRepository;

import java.util.ArrayList;
import java.util.List;

public class ControllerImpl implements Controller {
    private Player mainPlayer;
    private List<Player> civilPlayers;
    private List<Gun> guns;
    private GunRepository gunRepository;

    public ControllerImpl() {
        mainPlayer = new MainPlayer();
        civilPlayers = new ArrayList<>();
        guns = new ArrayList<>();
        gunRepository = new GunRepository();
    }
    @Override
    public String addPlayer(String name) {
        CivilPlayer player = new CivilPlayer(name);
        civilPlayers.add(player);
        return String.format(ConstantMessages.PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun;
        switch (type) {
            case "Pistol":
                gun = new Pistol(name);
                break;
            case "Rifle":
                gun = new Rifle(name);
                break;
            default:
                return ConstantMessages.GUN_TYPE_INVALID;
        }
        guns.add(gun);
        return String.format(ConstantMessages.GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        if (guns.isEmpty()) {
            return ConstantMessages.GUN_QUEUE_IS_EMPTY;
        }
        Gun gun = guns.get(0);
        if (name.equals("Vercetti")) {
            mainPlayer.getGunRepository().add(gun);
            guns.remove(gun);
            return String.format(ConstantMessages.GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), mainPlayer.getName());
        }
        if (civilPlayers.stream().noneMatch(p -> p.getName().equals(name))) {
            return ConstantMessages.CIVIL_PLAYER_DOES_NOT_EXIST;
        }
        civilPlayers.stream().filter(p -> p.getName().equals(name)).findFirst().get().getGunRepository().add(gun);
        guns.remove(gun);
        return String.format(ConstantMessages.GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), name);
    }

    @Override
    public String fight() {
        StringBuilder sb = new StringBuilder();
        GangNeighbourhood gangNeighbourhood = new GangNeighbourhood();

        int sizeBefore = civilPlayers.size();

        gangNeighbourhood.action(mainPlayer, civilPlayers);

        int sizeAfter = civilPlayers.size();
        int killedEnemy = sizeBefore - sizeAfter;

        if (mainPlayer.getLifePoints() == 100 && civilPlayers.stream().noneMatch(p -> p.getLifePoints() != 50) && sizeAfter == sizeBefore){
            sb.append(ConstantMessages.FIGHT_HOT_HAPPENED);
        }else {
            sb.append(ConstantMessages.FIGHT_HAPPENED).append(System.lineSeparator());
            sb.append(String.format(ConstantMessages.MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints()))
                    .append(System.lineSeparator());
            sb.append(String.format(ConstantMessages.MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, killedEnemy))
                    .append(System.lineSeparator());
            sb.append(String.format(ConstantMessages.CIVIL_PLAYERS_LEFT_MESSAGE, sizeAfter)).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
