package exam_preparation.nfs.controllers;

import exam_preparation.nfs.models.Cars.Car;
import exam_preparation.nfs.models.Cars.PerformanceCar;
import exam_preparation.nfs.models.Cars.ShowCar;
import exam_preparation.nfs.models.Garage.Garage;
import exam_preparation.nfs.models.Races.CasualRace;
import exam_preparation.nfs.models.Races.DragRace;
import exam_preparation.nfs.models.Races.Race;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ivaylo on 11/5/2017.
 */
public class CarManager {

    private Map<Integer, Car> registeredCars;
    private Map<Integer, Race> openedRaces;
    private Garage garage;

    public CarManager() {
        this.registeredCars = new HashMap<>();
        this.openedRaces = new HashMap<>();
        this.garage = new Garage();

    }

    public void register(Integer id, String type, String brand, String model,
                         int yearOfProduction, int horsepower, int acceleration,
                         int suspension, int durability){

        switch (type){
            case "Performance" : this.registeredCars.put(id,
                    new PerformanceCar(brand, model, yearOfProduction, horsepower,
                            acceleration, suspension, durability));
                break;
            case "Show" : this.registeredCars.put(id,
                    new ShowCar(brand, model, yearOfProduction, horsepower,
                            acceleration, suspension, durability));
                break;
        }
    }

    public String check(Integer id){
        return this.registeredCars.get(id).toString();
    }

    public void open(Integer id, String type, int length, String route, int prizePool){
        switch (type){
            case "Casual" : this.openedRaces.put(id,
                    new CasualRace(length, route, prizePool));
                break;
            case "Drag" : this.openedRaces.put(id,
                    new DragRace(length, route, prizePool));
                break;
            case "Drift" : this.openedRaces.put(id,
                    new DragRace(length, route, prizePool));
                break;
        }
    }

    public void participate(Integer carId, Integer raceId){
        Car car = this.registeredCars.get(carId);
        if(car.isParked()){
            return;
        }
        Race race = this.openedRaces.get(raceId);
        race.addCar(car);

    }

    public String start(int id){
        return this.openedRaces.remove(id).toString();

    }

    public void park(int carId){
        Car car = this.registeredCars.get(carId);
        if(car.isInRace()){
            return;
        }
        this.garage.park(carId, car);
    }

    public void unpark(int carId){
        this.garage.unpark(carId);
    }

    public void tune (int tuneIndex, String tuneAddOn){
        this.garage.tune(tuneIndex, tuneAddOn);
    }




}
