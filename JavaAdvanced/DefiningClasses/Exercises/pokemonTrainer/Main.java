package definingClassesExercise.pokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Trainer> trainers = new ArrayList<>();
        String input = scanner.nextLine();

        while (!input.equals("Tournament")){
            String trainerName = input.split("\\s+")[0];
            String pokemonName = input.split("\\s+")[1];
            String pokemonElement = input.split("\\s+")[2];
            int pokemonHealth = Integer.parseInt(input.split("\\s+")[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            if(!hasTrainerWhitThisName(trainerName, trainers)){
               trainers.add(new Trainer(trainerName));
            }
            Trainer current = trainers.stream().filter(e -> e.getName().equals(trainerName)).findFirst().get();
            current.getPokemons().add(pokemon);

            input = scanner.nextLine();
        }

        String element = scanner.nextLine();

        while (!element.equals("End")){

            playTournament(element, trainers);

            element = scanner.nextLine();
        }


        trainers.stream().sorted((f,s) -> {
            int sort = Integer.compare(s.getBadges(),f.getBadges());
            return sort;
        }).forEach(System.out::println);

    }
    public static void playTournament(String element, List<Trainer> list){
        boolean havePokemonWhitThisElement = false;
        for(var t : list){
            for(var p : t.getPokemons()){
                if(p.getElement().equals(element)){
                    t.setBadges(t.getBadges() + 1);
                    havePokemonWhitThisElement = true;
                    break;
                }
                havePokemonWhitThisElement = false;
            }
            if(!havePokemonWhitThisElement){
                for(var p : t.getPokemons()){
                    p.setHealth(p.getHealth() - 10);
                }
                for(Trainer trainer : list){
                    trainer.getPokemons().removeIf(pokemon -> pokemon.getHealth() <= 0);
                }
            }

        }

    }
    public static boolean hasTrainerWhitThisName(String name, List<Trainer> list){
        for(var t : list){
            if(t.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
}
