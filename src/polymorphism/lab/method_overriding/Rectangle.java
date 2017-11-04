package polymorphism.lab.method_overriding;

class Rectangle {

    private double	height;
    private double width;
    private double area;

    Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
        setArea();
    }

    double getArea() {
        return area;
    }

    private void setArea() {
        this.area = this.height * this.width;
    }
}
