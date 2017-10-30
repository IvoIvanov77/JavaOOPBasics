package defining_classes.exercise.pokemon_trainer;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

class Tournament {

    private Map<String, Trainer> trainers;

    Tournament() {
        this.trainers = new LinkedHashMap<>();
    }

    void addTrainer(String line){

        String[] input = line.split(" ");
        String trainerName = input[0];
        String pokemonName = input[1];
        String element = input[2];
        int health = Integer.parseInt(input[3]);

        trainers.computeIfAbsent(trainerName, v -> new Trainer(trainerName));

        trainers.get(trainerName).addPokemon(new Pokemon(pokemonName, element, health));

    }

    void play(String element){
        for (Trainer trainer : trainers.values()) {
            if(trainer.hasElement(element)){
                trainer.increaseBadges();
            }
        }
    }

    void printTrainers(){
        this.trainers.values().stream()
                .sorted(Comparator.comparing(Trainer::getNumberOfBadges).reversed())
                .forEach(System.out::println);
    }

}
