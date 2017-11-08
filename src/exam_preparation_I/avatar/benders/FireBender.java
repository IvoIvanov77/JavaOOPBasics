package exam_preparation_I.avatar.benders;

public class FireBender extends Bender{

    private double heatAggression;

    public FireBender(String name, int power, double heatAggression) {
        super(name, power);
        this.heatAggression = heatAggression;
    }

    @Override
    public double getTotalPower() {
        return this.heatAggression * this.getPower();
    }

    @Override
    public String toString() {
        return String.format("Fire Bender: %s, Heat Aggression: %.2f", super.toString(), this.heatAggression);
    }
}
