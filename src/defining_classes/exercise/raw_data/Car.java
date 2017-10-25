package defining_classes.exercise.raw_data;

class Car {

//    You are the owner of a courier company and want to make a system for tracking your cars and their cargo.
//    Define a class Car that holds information about model, engine, cargo and a collection of exactly 4 tires.
//    The engine, cargo and tire should be separate classes, create a constructor that receives all information about
//    the Car and creates and initializes its inner components (engine, cargo and tires).

    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire[] tires;

    public Car(String model, Engine engine, Cargo cargo, Tire[] tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    static Car getInstanceFromString(String line){
        String[] token = line.split("\\s+");

        String model = token[0];
        Engine engine = Engine.getInstanceFromString(token[1], token[2]);
        Cargo cargo = Cargo.getInstanceFromString(token[3], token[4]);
        Tire[] tires = new Tire[4];
        int index = 0;
        for (int i = 5; i < token.length; i+=2) {
            tires[index] = Tire.getInstanceFromString(token[i], token[i + 1]);
            index ++;
        }

        return new Car(model, engine, cargo, tires);
    }

    String getModel() {
        return model;
    }

    Engine getEngine() {
        return engine;
    }

    Cargo getCargo() {
        return cargo;
    }

    private Tire[] getTires() {
        return tires;
    }

    boolean hasLowPressureTire(){

        for (Tire tire : tires) {
            if(tire.getPressure() < 1){
                return true;
            }

        }

       return false;
    }
}
