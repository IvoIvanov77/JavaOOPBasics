package defining_classes.exercise.raw_data;

class Tire {

    private int age;
    private double pressure;

    private Tire(double pressure, int age) {
        this.pressure = pressure;
        this.age = age;
    }

    static Tire getInstanceFromString(String pressureString, String ageString){

        double pressure = Double.parseDouble(pressureString);
        int age = Integer.parseInt(ageString);

        return new Tire(pressure, age);
    }

    double getPressure() {
        return pressure;
    }
}
