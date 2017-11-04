package polymorphism.exercises.vehicles_extension;

class Truck extends Vehicle {


    Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
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
        super.refueling(amount * 0.95);

    }


}
