package polymorphism.exercises.vehicles_extension;

import java.text.DecimalFormat;

public abstract class Vehicle {

//    fuel quantity, fuel consumption
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    double getFuelQuantity() {
        return fuelQuantity;
    }

    void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    double getFuelConsumption() {
        return fuelConsumption;
    }

    void printDistance(double distance){
        DecimalFormat format = new DecimalFormat("0.##");
        System.out.println(String.format("%s travelled %s km", this.getClass().getSimpleName(),
                format.format(distance)));
    }

    abstract void drive(double distance);

    void refueling(double amount){
        if(amount <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if(this.fuelQuantity + amount > this.tankCapacity)
            throw new IllegalArgumentException("Cannot fit fuel in tank");

        this.setFuelQuantity(this.getFuelQuantity() +  amount);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
