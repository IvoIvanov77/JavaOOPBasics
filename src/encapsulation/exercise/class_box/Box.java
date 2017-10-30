package encapsulation.exercise.class_box;

class Box {

//    length, width and height
    private double length;
    private double width;
    private double height;

    Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    private double getVolume(){
        return this.height * this.length * this.width;

    }
// 2lh + 2wh
    private double getLateralSurfaceArea(){
        return  2 * (this.length * this.height + this.width * this.height);
    }
//2lw + 2lh + 2wh
    private double getSurfaceArea(){
        return  2 * (this.length * this.height
                + this.width * this.height
                + this.length * this.width);
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %.2f\n" +
                "Lateral Surface Area - %.2f\n" +
                "Volume - %.2f",
                this.getSurfaceArea(),
                this.getLateralSurfaceArea(),
                this.getVolume());
    }
}
