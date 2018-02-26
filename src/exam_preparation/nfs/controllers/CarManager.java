package exam_preparation.nfs.controllers;

import exam_preparation.nfs.models.Cars.Car;
import exam_preparation.nfs.models.Cars.PerformanceCar;
import exam_preparation.nfs.models.Cars.ShowCar;
import exam_preparation.nfs.models.Garage.Garage;
import exam_preparation.nfs.models.Races.*;

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

    public void run(String line){

        String[] input = line.split(" ");
        String command = input[0];
        int id = Integer.parseInt(input[1]);

        switch (command){
            case "register" : register(
                    id, input[2], input[3], input[4], Integer.parseInt(input[5]),
                    Integer.parseInt(input[6]), Integer.parseInt(input[7]),
                    Integer.parseInt(input[8]), Integer.parseInt(input[9])
                    );
                    break;
            case "open" : {
                if(input.length == 6){
                    open(id, input[2], Integer.parseInt(input[3]), input[4], Integer.parseInt(input[5]));
                }else {
                    openSpecialRace(id, input[2], Integer.parseInt(input[3]), input[4],
                            Integer.parseInt(input[5]),Integer.parseInt(input[6]));
                }

            }
                    break;
            case "participate" : participate(id, Integer.parseInt(input[2]));
                break;
            case "check" :
                System.out.println(check(id));
                break;
            case "start" :
                System.out.println(start(id));
                break;
            case "park" : park(id);
                break;
            case "unpark" : unpark(id);
                break;
            case "tune" : tune(id, input[2]);
        }

    }

    public void register(int id, String type, String brand, String model,
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
//    java.lang.NoSuchMethodException: exam_preparation.nfs.controllers.CarManager.
// register(int, java.lang.String, java.lang.String, java.lang.String, int, int, int, int, int)

    public String check(int id){
        return this.registeredCars.get(id).toString();
    }

    public void open(int id, String type, int length, String route, int prizePool){
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

    public void openSpecialRace(int id, String type, int length, String route, int prizePool, int extraParameter){
        switch (type) {
            case "TimeLimit":
                this.openedRaces.put(id,
                        new TimeLimitRace(length, route, prizePool, extraParameter));
                break;
            case "Circuit":
                this.openedRaces.put(id,
                        new CircuitRace(length, route, prizePool, extraParameter));
                break;
        }
    }

    public void participate(int carId, int raceId){
        Car car = this.registeredCars.get(carId);
        if(car.isParked()){
            return;
        }
        Race race = this.openedRaces.get(raceId);
        race.addCar(car);

    }

    public String start(int id){

        Race race = this.openedRaces.get(id);
        try{
            race.start();

        }catch (UnsupportedOperationException uoe){
            return uoe.getMessage();
        }

        this.openedRaces.remove(id);
        return race.toString();

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

    public void tune(int tuneIndex, String tuneAddOn){
        this.garage.tune(tuneIndex, tuneAddOn);
    }




}
