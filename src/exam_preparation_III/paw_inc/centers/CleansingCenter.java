package exam_preparation_III.paw_inc.centers;

import exam_preparation_III.paw_inc.animals.Animal;

import java.util.*;

public class CleansingCenter extends Center {

    private List<Animal> animals;

    public CleansingCenter(String name) {
        super(name);
        this.animals = new ArrayList<>();
    }

    public void receiveAnimalsForCleaning(Collection<Animal> animals){
        this.animals.addAll(animals);
    }

    public Collection<Animal> sendCleanedAnimals(){
        List<Animal> animalForSending = new ArrayList<>(this.animals);
        this.animals.clear();
        return animalForSending;
    }


}
