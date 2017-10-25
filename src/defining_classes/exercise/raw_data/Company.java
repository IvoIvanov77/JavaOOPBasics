package defining_classes.exercise.raw_data;

import java.util.LinkedHashMap;
import java.util.Map;

class Company {

    private Map<String, Car> cars;

    Company() {
        cars = new LinkedHashMap<>();
    }

    void addCar(String line){
        Car car = Car.getInstanceFromString(line);
        cars.put(car.getModel(), car);

    }

    void printCars(String type){
        switch (type){
            case "fragile" :
                this.cars.values().stream()
                        .filter(car -> car.getCargo().getType().equals(type))
                        .filter(Car::hasLowPressureTire)
                        .forEach(car -> System.out.println(car.getModel()));
                break;

            case "flamable" :
                this.cars.values().stream()
                        .filter(car -> car.getCargo().getType().equals(type))
                        .filter(car -> car.getEngine().getPower() > 250)
                        .forEach(car -> System.out.println(car.getModel()));
                break;

        }
    }


}
