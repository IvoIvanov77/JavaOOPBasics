package defining_classes.exercise.pokemon_trainer;

public class Pokemon {

    private String name;
    private String element;
    private int health;

    Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    String getElement() {
        return element;
    }

    void lose10Health(){
        this.health -= 10;
    }

    boolean isDeath(){
        return this.health <= 0;
    }

}
