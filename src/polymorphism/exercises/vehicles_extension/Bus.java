package polymorphism.exercises.vehicles_extension;

class Bus extends Vehicle {

    Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    void drive(double distance) {
        double summerConsumption = this.getFuelConsumption() + 1.4;
        if(summerConsumption * distance <= this.getFuelQuantity()){
            this.printDistance(distance);
            this.setFuelQuantity(this.getFuelQuantity() - summerConsumption * distance);
        }else {
            System.out.println("Bus needs refueling");
        }
    }

    void driveEmpty(double distance){

        if(this.getFuelConsumption() * distance <= this.getFuelQuantity()){
            this.printDistance(distance);
            this.setFuelQuantity(this.getFuelQuantity() - this.getFuelConsumption() * distance);
        }else {
            System.out.println("Bus needs refueling");
        }
    }

}
