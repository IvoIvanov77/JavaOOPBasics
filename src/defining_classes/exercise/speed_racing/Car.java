package defining_classes.exercise.speed_racing;

class Car {

    //Model, fuel amount, fuel cost for 1 kilometer and distance

    private String model;
    private double fuelAmount;
    private double fuelCostForKm;
    private double traveledDistance;

    private Car(String model, double fuelAmount, double fuelCostForKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostForKm = fuelCostForKm;
        this.traveledDistance = 0;
    }

    static Car getInstanceForString(String line){
        String[] input = line.split("\\s+");
        String model = input[0];
        double fuelAmount = Double.parseDouble(input[1]);
        double fuelCost = Double.parseDouble(input[2]);
        return new Car(model, fuelAmount, fuelCost);
    }


    String getModel() {
        return model;
    }

    double getFuelAmount() {
        return fuelAmount;
    }

    double getTraveledDistance() {
        return traveledDistance;
    }

    void drive(double distance){
        double neededFuel = distance * fuelCostForKm;
        if(neededFuel > fuelAmount){
            System.out.println("Insufficient fuel for the drive");
            return;
        }
        traveledDistance += distance;
        fuelAmount -= neededFuel;

    }
}
