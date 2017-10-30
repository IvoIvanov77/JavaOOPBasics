package defining_classes.exercise.car_salesman;

public class Engine {

//    model, power, displacement and efficiency.

    private String model;
    private String power;
    private String displacement;
    private String efficiency;

    public Engine(String model, String power, Integer displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement == null ? "n/a" : displacement.toString();
        this.efficiency = efficiency;
    }


    public Engine(String model, String power) {
        this(model, power, null, "n/a");
    }

    public Engine(String model, String power, Integer displacement) {
        this(model, power, displacement, "n/a");
    }

    public Engine(String model, String power, String efficiency) {
        this(model, power, null, efficiency);
    }

    static Engine getInstance(String line){

        Engine engine;
        String[] input = line.split("\\s+");
        String model = input[0];
        String power = input[1];

        if(input.length == 2){
            engine = new Engine(model, power);
        }else if(input.length == 3){
            try {
                Integer displacement = Integer.parseInt(input[2]);
                engine = new Engine(model, power, displacement);
            }catch(NumberFormatException e) {
                String efficiency = input[2];
                engine = new Engine(model,power, efficiency);
            }
        }else {
            Integer displacement = Integer.parseInt(input[2]);
            String efficiency = input[3];
            engine = new Engine(model, power, displacement, efficiency);
        }
        return engine;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return String.format("%s:\n" +
                "    Power: %s\n" +
                "    Displacement: %s\n" +
                "    Efficiency: %s",
                this.model, this.power, this.displacement, this.efficiency);
    }
}
