package inheritance.lab.reusing_classes;

public class Predator extends Animal{

    private int health = 0;

//    void feed(Food food){
//        super.eat(food);
//    }


    void feet(Food food) {
        super.eat(food);
        this.health ++;
    }

    public int getHealth() {
        return health;
    }
}
