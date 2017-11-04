package polymorphism.lab.shapes;

public class Circle extends Shape{

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
        setArea(calculateArea());
        setPerimeter(calculatePerimeter());
    }

    public final double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    protected double calculateArea() {
        return Math.PI * this.radius * this.radius;
    }

    @Override
    protected double calculatePerimeter() {
        return Math.PI * 2 * this.radius;
    }


}
