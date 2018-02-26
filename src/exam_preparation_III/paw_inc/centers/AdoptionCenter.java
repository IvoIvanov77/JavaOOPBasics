package exam_preparation_III.paw_inc.centers;

import exam_preparation_III.paw_inc.animals.Animal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AdoptionCenter extends Center {

    private List<Animal> dirtyAnimals;
    private List<Animal> cleanAnimals;

    public AdoptionCenter(String name) {
        super(name);
        this.dirtyAnimals = new ArrayList<>();
        this.cleanAnimals = new ArrayList<>();
    }

    public Collection<Animal> sendingAnimalsForCleansing(){
        List<Animal> animalForSending = new ArrayList<>(dirtyAnimals);
        this.dirtyAnimals.clear();
        return animalForSending;
    }

    public Collection<Animal> adoptAnimals(){
        List<Animal> adoptAnimals = new ArrayList<>(this.cleanAnimals);
        this.cleanAnimals.clear();
        return adoptAnimals;
    }

    public void registerAnimal(Animal animal){
        this.dirtyAnimals.add(animal);
    }

    public void receiveCleanedAnimals(Collection<Animal> cleanedAnimal){
        for (Animal animal : cleanedAnimal) {
            if(animal.getAdoptionCenter().equals(this.getName())){
                this.cleanAnimals.add(animal);
            }
        }

    }

    public void receiveCastratedAnimals(Collection<Animal> castratedAnimal){
        for (Animal animal : castratedAnimal) {
            if(animal.getAdoptionCenter().equals(this.getName())){
                this.dirtyAnimals.add(animal);
            }
        }

    }
}
