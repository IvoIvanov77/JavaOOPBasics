package defining_classes.exercise.cat_lady;

public class Cat {

    private String breed;
    private String name;
    private double someNumber;

    Cat(String line) {
        String[] input = line.split(" ");
        this.breed = input[0];
        this.name = input[1];
        this.someNumber = Double.parseDouble(input[2]);
    }

    private String getBreed() {
        return breed;
    }

    public String getName() {
        return name;
    }

    private double getSomeNumber() {
        return someNumber;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.getBreed(), this.getName(), this.getSomeNumber());
    }
}
