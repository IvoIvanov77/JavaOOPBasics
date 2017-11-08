package exam_preparation_I.avatar.benders;

public abstract class Bender {

    private String name;
    private int power;

    Bender(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public abstract double getTotalPower();

    @Override
    public String toString() {
        return String.format("%s, Power: %d", this.name, this.power);
    }
}
