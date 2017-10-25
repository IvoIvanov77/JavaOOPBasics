package defining_classes.exercise.raw_data;

public class Cargo {
    private int weight;
    private String type;

    private Cargo(int weight, String type) {
        this.weight = weight;
        this.type = type;
    }

    static Cargo getInstanceFromString(String weightString, String type){
        int weight = Integer.parseInt(weightString);
        return new Cargo(weight, type);
    }

    public int getWeight() {
        return weight;
    }

    String getType() {
        return type;
    }
}
