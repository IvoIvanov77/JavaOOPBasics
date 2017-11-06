package exam_preparetion.nfs.models.Cars;

import java.util.Collection;

/**
 * Created by ivaylo on 11/5/2017.
 */
public abstract class Car {

//    a brand (string), a model (string), an yearOfProduction (int),
// horsepower (int), acceleration (int), suspension (int), and durability (int).

    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;
    private boolean isParked;
    private boolean isInRace;

    public Car(String brand, String model, int yearOfProduction,
               int horsepower, int acceleration, int suspension,
               int durability) {
        this.setBrand(brand);
        this.setModel(model);
        this.setYearOfProduction(yearOfProduction);
        this.setHorsepower(horsepower);
        this.setAcceleration(acceleration);
        this.setSuspension(suspension);
        this.setDurability(durability);
        this.setParked(false);
        this.setInRace(false);
    }

    public String getBrand() {
        return brand;
    }

    private void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    private void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public int getHorsepower() {
        return horsepower;
    }

    protected void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getAcceleration() {
        return acceleration;
    }

    private void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public int getSuspension() {
        return suspension;
    }

    protected void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    public int getDurability() {
        return durability;
    }

    private void setDurability(int durability) {
        this.durability = durability;
    }

    public boolean isParked() {
        return isParked;
    }

    public void setParked(boolean parked) {
        isParked = parked;
    }

    public boolean isInRace() {
        return isInRace;
    }

    public void setInRace(boolean inRace) {
        isInRace = inRace;
    }

    public void tune(int index, String addOn){
        this.horsepower += index;
        this.suspension += index /2;
    }

    @Override
    public String toString() {
        return String.format(
                "%s %s %d\n" +
                "%d HP, 100 m/h in %d s\n" +
                        "%d Suspension force, %d Durability",
                this.getBrand(), this.getModel(), this.getYearOfProduction(),
                this.getHorsepower(), this.getAcceleration(),
                this.getSuspension(), this.getDurability()
        );
    }





    //    “{brand} {model} {yearOfProduction}
//    {horsepower} HP, 100 m/h in {acceleration} s
//    {suspension} Suspension force, {durability} Durability”
//    If the car is a PerformanceCar, you must print “Add-ons: {add-ons}”, on the
//    last line – each add-on separated by a comma and a space “, “. In case there are
//    NO add-ons, print “None”.
//    If the car is a ShowCar, you must print “{stars} *”, on the last line.

}
