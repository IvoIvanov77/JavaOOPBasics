package polymorphism.exercises.vehicles_extension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carData = reader.readLine().split(" ");
        String[] truckData = reader.readLine().split(" ");
        String[] busData = reader.readLine().split(" ");

        Car car = new Car(Double.parseDouble(carData[1]),
                Double.parseDouble(carData[2]), Double.parseDouble(carData[3]));
        Truck truck = new Truck(Double.parseDouble(truckData[1]),
                Double.parseDouble(truckData[2]), Double.parseDouble(truckData[3]));
        Bus bus = new Bus(Double.parseDouble(busData[1]),
                Double.parseDouble(busData[2]), Double.parseDouble(busData[3]));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            try{
                parseInput(reader, car, truck, bus);
            }catch(IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }

        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);

    }

    private static void parseInput(BufferedReader reader, Car car, Truck truck, Bus bus) throws IOException {
        String[] commands = reader.readLine().split(" ");
        switch (commands[0]){
            case "Drive" :{
                String vehicle = commands[1];
                double distance = Double.parseDouble(commands[2]);
                switch (vehicle) {
                    case "Car":
                        car.drive(distance);
                        break;
                    case "Truck":
                        truck.drive(distance);
                        break;
                    case "Bus":
                        bus.drive(distance);
                        break;
                }
                break;
            }
            case "Refuel" :{
                String vehicle = commands[1];
                double amount = Double.parseDouble(commands[2]);
                switch (vehicle) {
                    case "Car":
                        car.refueling(amount);
                        break;
                    case "Truck":
                        truck.refueling(amount);
                        break;
                    case "Bus":
                        bus.refueling(amount);
                        break;
                }
                break;
            }

            case "DriveEmpty" :{
                double distance = Double.parseDouble(commands[2]);
                bus.driveEmpty(distance);
                break;
            }
        }
    }
}
