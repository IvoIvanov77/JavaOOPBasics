package exam_preparetion.nfs;

import exam_preparetion.nfs.models.Cars.Car;
import exam_preparetion.nfs.models.Cars.PerformanceCar;
import exam_preparetion.nfs.models.Cars.ShowCar;

/**
 * Created by ivaylo on 11/5/2017.
 */
public class Main {
    public static void main(String[] args) {

        Car car = new PerformanceCar("Trabant", "601",
                1988, 2000, 1, 10000,
                1000
        );

        Car car1 = new ShowCar("Porsche", "Carrera", 2017,
                550, 4, 300, 100
        );

        car.tune(1000, "Ivaylo");
        car1.tune(500, "None");
        System.out.println(car);
        System.out.println(car1);

    }
}
