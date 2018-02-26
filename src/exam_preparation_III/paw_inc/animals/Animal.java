package exam_preparation_III.paw_inc.animals;

public abstract class Animal {

    private String name;
    private int age;
    private String adoptionCenter;

    protected Animal(String animalName, int animalAge) {
        this.setAnimalName(animalName);
        this.setAnimalAge(animalAge);
    }

    protected Animal(String animalName, int animalAge, String adoptionCenter) {
        this(animalName,animalAge);
        this.setAdoptionCenter(adoptionCenter);
    }

    public String getAdoptionCenter() {
        return adoptionCenter;
    }

    public String getAnimalName() {
        return name;
    }

    private void setAnimalName(String animalName) {
        this.name = animalName;
    }

    public int getAnimalAge() {
        return age;
    }

    private void setAnimalAge(int animalAge) {
        this.age = animalAge;
    }

    private void setAdoptionCenter(String adoptionCenter) {
        this.adoptionCenter = adoptionCenter;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
