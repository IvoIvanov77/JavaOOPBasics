package exam_preparation_III.paw_inc.animals;

public class Cat extends Animal {


    private int intelligenceCoefficient;

    public Cat(String animalName, int animalAge, int intelligenceCoefficient) {
        super(animalName, animalAge);
        this.setIntelligenceCoefficient(intelligenceCoefficient);
    }

    public Cat(String animalName, int animalAge, String adoptionCenter, int intelligenceCoefficient) {
        super(animalName, animalAge, adoptionCenter);
        this.setIntelligenceCoefficient(intelligenceCoefficient);
    }

    public int getIntelligenceCoefficient() {
        return intelligenceCoefficient;
    }

    private void setIntelligenceCoefficient(int intelligenceCoefficient) {
        this.intelligenceCoefficient = intelligenceCoefficient;
    }


}
