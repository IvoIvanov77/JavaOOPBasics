package exam_preparation_I.avatar.benders;

public class AirBender extends Bender {

    private double aerialIntegrity;

    public AirBender(String name, int power, double aerialIntegrity) {
        super(name, power);
        this.aerialIntegrity = aerialIntegrity;
    }

    @Override
    public double getTotalPower() {
        return this.aerialIntegrity * this.getPower();
    }

    @Override
    public String toString() {
        return String.format("Air Bender: %s, Aerial Integrity: %.2f", super.toString(), this.aerialIntegrity);
    }
}
