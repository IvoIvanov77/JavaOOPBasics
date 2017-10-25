package defining_classes.exercise.raw_data;

class Engine {

    private int speed;
    private int power;

    private Engine(int speed, int power) {
        this.speed = speed;
        this.power = power;
    }

    static Engine getInstanceFromString(String speedString, String powerString){

        int speed = Integer.parseInt(speedString);
        int power = Integer.parseInt(powerString);

        return new Engine(speed, power);
    }

    int getPower() {
        return power;
    }
}
