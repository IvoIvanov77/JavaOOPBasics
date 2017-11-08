package exam_preparation_I.avatar.benders;

public class EarthBender extends Bender{


    private double groundSaturation;

        public EarthBender(String name, int power, double groundSaturation) {
            super(name, power);
            this.groundSaturation = groundSaturation;
        }

    @Override
    public double getTotalPower() {
        return this.groundSaturation * this.getPower();
    }

    @Override
    public String toString() {
        return String.format("Earth Bender: %s, Ground Saturation: %.2f", super.toString(), this.groundSaturation);
    }
}
