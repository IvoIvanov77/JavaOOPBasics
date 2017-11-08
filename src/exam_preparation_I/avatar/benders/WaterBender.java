package exam_preparation_I.avatar.benders;

public class WaterBender extends Bender{

    private double waterClarity;

    public WaterBender(String name, int power, double waterClarity) {
        super(name, power);
        this.waterClarity = waterClarity;
    }

    @Override
    public double getTotalPower() {
        return this.waterClarity * this.getPower();
    }

    @Override
    public String toString() {
        return String.format("Water Bender: %s, Water Clarity: %.2f", super.toString(), this.waterClarity);
    }
}
