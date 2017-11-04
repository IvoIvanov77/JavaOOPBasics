package polymorphism.exercises.vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {

//    fuel quantity, fuel consumption
    private double fuelQuantity;
    private double fuelConsumption;

    Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
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

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    abstract void drive(double distance);
    abstract void refueling(double amount);

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
