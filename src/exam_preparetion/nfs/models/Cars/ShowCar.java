package exam_preparetion.nfs.models.Cars;

import exam_preparetion.nfs.models.Cars.Car;

/**
 * Created by ivaylo on 11/5/2017.
 */
public class ShowCar extends Car {

    private int stars;

    public ShowCar(String brand, String model, int yearOfProduction, int horsepower,
                   int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.stars = 0;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + this.stars + " *";
    }


    @Override
    public void tune(int index, String addOn) {
        super.tune(index, addOn);
        this.stars += index;
    }
}
