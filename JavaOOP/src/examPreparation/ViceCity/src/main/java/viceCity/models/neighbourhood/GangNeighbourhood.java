package viceCity.models.neighbourhood;

import viceCity.Main;
import viceCity.models.guns.Gun;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class GangNeighbourhood implements Neighbourhood {


    public GangNeighbourhood() {
    }
    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {

        while (!mainPlayer.getGunRepository().getModels().isEmpty() && !civilPlayers.isEmpty()) {
            Gun gun = mainPlayer.getGunRepository().getModels().iterator().next();

                for (Player civil : civilPlayers) {

                    while (gun.canFire() && civil.isAlive()) {
                        civil.takeLifePoints(gun.fire());
                    }

                    if (!gun.canFire()) {
                        mainPlayer.getGunRepository().getModels().remove(gun);
                        break;
                    }

                }
            civilPlayers.removeIf(p -> p.getLifePoints() == 0);
        }


        for (Player civilPlayer : civilPlayers) {

            while (!civilPlayer.getGunRepository().getModels().isEmpty()) {
                Gun gun = civilPlayer.getGunRepository().getModels().iterator().next();

                while (gun.canFire() && mainPlayer.isAlive()) {
                    mainPlayer.takeLifePoints(gun.fire());
                    if(!mainPlayer.isAlive()){
                        return;
                    }
                }

                if (!gun.canFire()) {
                    civilPlayer.getGunRepository().remove(gun);
                    break;
                }
            }
        }
    }
}
