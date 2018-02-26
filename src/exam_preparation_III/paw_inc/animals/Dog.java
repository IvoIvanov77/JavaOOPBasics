package exam_preparation_III.paw_inc.animals;

public class Dog extends Animal {

//    amount of commands it has learned
    private int learnedCommands;

    public Dog(String animalName, int animalAge, int learnedCommands) {
        super(animalName, animalAge);
        this.setLearnedCommands(learnedCommands);
    }

    public Dog(String animalName, int animalAge, String adoptionCenter, int learnedCommands) {
        super(animalName, animalAge, adoptionCenter);
        this.setLearnedCommands(learnedCommands);
    }


    public int getLearnedCommands() {
        return learnedCommands;
    }

    private void setLearnedCommands(int learnedCommands) {
        this.learnedCommands = learnedCommands;
    }
}
