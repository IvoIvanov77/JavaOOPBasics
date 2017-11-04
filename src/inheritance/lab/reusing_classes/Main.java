package inheritance.lab.reusing_classes;

public class Main {

    public static void main(String[] args) {

        Predator predator = new Predator();

        predator.eat(new Food());
        predator.eat(new Food());
        predator.eatAll(new Food[]{new Food(), new Food()});
        System.out.println(predator.getHealth());
    }
}
