package polymorphism.exercises.wild_farm;

import java.text.DecimalFormat;

abstract class Mammal extends Animal {

//    {AnimalType} {AnimalName} {AnimalWeight} {AnimalLivingRegion} [{CatBreed} = Only if its cat]

    private final DecimalFormat format = new DecimalFormat("#.##");
    private String livingRegion;


    Mammal(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight);
        this.livingRegion = livingRegion;
    }

    String getLivingRegion() {
        return livingRegion;
    }

    public DecimalFormat getFormat() {
        return format;
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %d]",this.getAnimalType(),
                this.getAnimalName(), this.getFormat().format(this.getAnimalWeight()),
                this.getLivingRegion(), this.getFoodEaten());
    }
}
