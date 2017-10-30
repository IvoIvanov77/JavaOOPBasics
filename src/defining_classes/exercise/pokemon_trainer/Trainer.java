package defining_classes.exercise.pokemon_trainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {

    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemons;

    Trainer(String name) {
        this.name = name;
        this.numberOfBadges = 0;
        this.pokemons = new ArrayList<>();
    }

    int getNumberOfBadges() {
        return numberOfBadges;
    }

    void increaseBadges(){
        this.numberOfBadges ++;
    }

    boolean hasElement(String element){
        for (Pokemon pokemon : pokemons) {
            if(pokemon.getElement().equals(element)){
                return true;
            }
        }
        int index = - 1;
        for (int i = 0; i < pokemons.size(); i ++) {
            Pokemon pokemon = pokemons.get(i);
            pokemon.lose10Health();
            if(pokemon.isDeath()){
                index = i;
            }
        }
        if(index > -1){
            pokemons.remove(index);
        }
        return false;
    }

    void addPokemon(Pokemon pokemon){
        this.pokemons.add(pokemon);
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.numberOfBadges, this.pokemons.size());
    }
}
