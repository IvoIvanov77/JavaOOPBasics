package polymorphism.exercises.vehicles;

public class Truck extends Vehicle {


    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    void drive(double distance) {
        double summerConsumption = this.getFuelConsumption() + 1.6;
        if(summerConsumption * distance <= this.getFuelQuantity()){
            this.printDistance(distance);
            this.setFuelQuantity(this.getFuelQuantity() - summerConsumption * distance);
        }else {
            System.out.println("Truck needs refueling");
        }

    }

    @Override
    void refueling(double amount) {

        this.setFuelQuantity(this.getFuelQuantity() + 0.95 * amount);

    }


}
