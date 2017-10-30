package encapsulation.exercise.class_box_data_validation;

class Box {

//    length, width and height
    private double length;
    private double width;
    private double height;

    Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        if(length <= 0){
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if(width <= 0){
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if(height <= 0){
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
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
