package guild;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {

    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild (String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer (Player player) {
        if(roster.size() < capacity) {
            roster.add(player);
        }
    }

    public boolean removePlayer (String name) {
        return roster.removeIf(p -> p.getName().equals(name));
    }

    public void promotePlayer (String name) {
        Player player = roster.stream().filter(p -> p.getName().equals(name)).findFirst().get();
        player.setRank("Member");
    }

    public void demotePlayer (String name) {
        Player player = roster.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst().get();
        player.setRank("Trial");
    }

    public Player[] kickPlayersByClass (String clazz) {
       Player[] kickedPlayers = roster.stream()
               .filter(p -> p.getClazz().equals(clazz))
               .toArray(Player[]::new);
       roster.removeAll(Arrays.stream(kickedPlayers).collect(Collectors.toList()));
       return kickedPlayers;
    }

    public int count () {
        return roster.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator()).append(String.format("Players in the guild: %s:",name)).append(System.lineSeparator());
        for (var p : roster){
            sb.append(p.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
