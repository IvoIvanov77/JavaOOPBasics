package exam_preparation_III.paw_inc.centers;

import exam_preparation_III.paw_inc.animals.Animal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CastrationCenter extends Center{

    private List<Animal> animals;

    public CastrationCenter(String name) {
        super(name);
        this.animals = new ArrayList<>();

    }

    public void receiveAnimalsForCastrating(Collection<Animal> animals){
        this.animals.addAll(animals);
    }

    public Collection<Animal> sendCastratedAnimals(){
        List<Animal> animalForSending = new ArrayList<>(this.animals);
        this.animals.clear();
        return animalForSending;
    }
}
