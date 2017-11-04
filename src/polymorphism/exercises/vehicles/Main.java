package polymorphism.exercises.vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carData = reader.readLine().split(" ");
        String[] truckData = reader.readLine().split(" ");

        Car car = new Car(Double.parseDouble(carData[1]), Double.parseDouble(carData[2]));
        Truck truck = new Truck(Double.parseDouble(truckData[1]), Double.parseDouble(truckData[2]));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {

            String[] commands = reader.readLine().split(" ");
            switch (commands[0]){
                case "Drive" :{
                    String vehicle = commands[1];
                    double distance = Double.parseDouble(commands[2]);
                    if(vehicle.equals("Car")){
                        car.drive(distance);
                    } else if(vehicle.equals("Truck")){
                        truck.drive(distance);
                    }
                    break;
                }
                case "Refuel" :{
                    String vehicle = commands[1];
                    double amount = Double.parseDouble(commands[2]);
                    if(vehicle.equals("Car")){
                        car.refueling(amount);
                    } else if(vehicle.equals("Truck")){
                        truck.refueling(amount);
                    }
                    break;
                }
            }
        }
        System.out.println(car);
        System.out.println(truck);

    }
}
