package polymorphism.exercises.vehicles;

public class Car extends  Vehicle {


    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
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

    @Override
    void refueling(double amount) {
        this.setFuelQuantity(this.getFuelQuantity() + amount);
    }


}
