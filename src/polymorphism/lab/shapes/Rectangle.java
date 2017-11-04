package polymorphism.lab.shapes;

public class Rectangle extends Shape {

    private double	height;
    private double width;

    Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
        super.setPerimeter(calculatePerimeter());
        super.setArea(calculateArea());
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    protected double calculateArea() {
        return this.height * this.width;
    }

    @Override
    protected double calculatePerimeter() {
        return 2 * (this.height + this.width);
    }
}
