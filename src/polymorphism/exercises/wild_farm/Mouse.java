package polymorphism.exercises.wild_farm;

class Mouse extends Mammal {

    Mouse(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    void eat(Food food) {
        if(food.getClass() != Vegetable.class){
            throw new IllegalArgumentException("Mice are not eating that type of food!");
        }
        super.eat(food);
    }


}
