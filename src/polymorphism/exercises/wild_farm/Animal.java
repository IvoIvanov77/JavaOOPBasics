package polymorphism.exercises.wild_farm;

public abstract class Animal {

    private String animalType;
    private String animalName;
    private Double animalWeight;
    private Integer foodEaten;

//    {AnimalType} {AnimalName} {AnimalWeight} {AnimalLivingRegion} [{CatBreed} = Only if its cat]


    public Animal(String animalType, String animalName, Double animalWeight) {
        this.animalType = animalType;
        this.animalName = animalName;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    String getAnimalType() {
        return animalType;
    }

    String getAnimalName() {
        return animalName;
    }

    Double getAnimalWeight() {
        return animalWeight;
    }

    Integer getFoodEaten() {
        return foodEaten;
    }

    abstract void makeSound();

     void eat(Food food){
         this.foodEaten = food.getQuantity();
     }


}
