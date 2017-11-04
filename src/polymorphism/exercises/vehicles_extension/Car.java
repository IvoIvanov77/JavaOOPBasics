package polymorphism.exercises.vehicles_extension;

public class Car extends Vehicle {


    Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    void drive(double distance) {

        double summerConsumption = this.getFuelConsumption() + 0.9;
        if(summerConsumption * distance <= this.getFuelQuantity()){
            this.printDistance(distance);
            this.setFuelQuantity(this.getFuelQuantity() - summerConsumption * distance);
        }else {
            System.out.println("Car needs refueling");
        }

    }




}
