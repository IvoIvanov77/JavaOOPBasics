package exam_preparation.nfs.models.Cars;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ivaylo on 11/5/2017.
 */
public class PerformanceCar extends Car {

    private Collection<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction,
                          int horsepower, int acceleration, int suspension,
                          int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.addOns = new ArrayList<>();
    }

    public void addAddOn(String addOn){
        this.addOns.add(addOn);
    }

    @Override
    protected void setHorsepower(int horsepower) {
        super.setHorsepower(horsepower + horsepower/2);
    }

    @Override
    protected void setSuspension(int suspension) {
        super.setSuspension(suspension - suspension / 4);
    }


    @Override
    public void tune(int index, String addOn) {
        super.tune(index, addOn);
        this.addOns.add(addOn);
    }

    @Override
    public String toString() {
        String addOns = this.addOns.isEmpty() ? "None"
                : this.addOns.toString().replaceAll("[\\[\\]]", "");
        return super.toString() +
                "\nAdd-ons: " + addOns;
    }
}
