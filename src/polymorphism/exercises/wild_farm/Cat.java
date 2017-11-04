package polymorphism.exercises.wild_farm;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalType, String animalName, Double animalWeight,
               String livingRegion, String bread) {
        super(animalType, animalName, animalWeight, livingRegion);
        this.breed = bread;
    }

    private String getBreed() {
        return breed;
    }

    @Override
    void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        return String.format(
                "%s[%s, %s, %s, %s, %d]",
                this.getAnimalType(),
                this.getAnimalName(),
                this.getBreed(),
                this.getFormat().format(this.getAnimalWeight()),
                this.getLivingRegion(),
                this.getFoodEaten()
        );
    }
}
