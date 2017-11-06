package exam_preparetion.nfs.models.Garage;

import exam_preparetion.nfs.models.Cars.Car;
import exam_preparetion.nfs.models.Cars.PerformanceCar;
import exam_preparetion.nfs.models.Cars.ShowCar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ivaylo on 11/5/2017.
 */
public class Garage {

    private Map<Integer, Car> parkedCars;

    public Garage() {
        this.parkedCars = new HashMap<>();
    }

    public void park(int id, Car car) {
        car.setParked(true);
        this.parkedCars.put(id,car);
    }

    public void unpark(int id) {
        if(this.parkedCars.containsKey(id)){
            this.parkedCars.remove(id);
        }
    }

    public void tune(int tuneIndex, String tuneAddOn) {
        for (Car parkedCar : parkedCars.values()) {
            parkedCar.tune(tuneIndex, tuneAddOn);
        }
    }


}
