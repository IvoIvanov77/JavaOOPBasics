package defining_classes.exercise.car_salesman;

public class Car {

//    A Car has a model, engine, weight and color. An Engine has model, power, displacement and efficiency.
//    A Car’s weight and color and its Engine’s displacements and efficiency are optional.

    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model, Engine engine, Integer weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight == null ? "n/a" : weight.toString();
        this.color = color;
    }

    public Car(String model, Engine engine) {
        this(model, engine, null, "n/a");
    }

    public Car(String model, Engine engine, Integer weight) {
        this(model, engine, weight, "n/a");
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, null, color);
    }

    @Override
    public String toString() {
        return String.format("%s:\n" +
                "  %s\n" +
                "  Weight: %s\n" +
                "  Color: %s",
                this.model, this.engine.toString(), this.weight, this.color);
    }
}
