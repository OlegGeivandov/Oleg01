public class Rectangle extends Figure {

    private double side1;

    private double side2;

    public Rectangle(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public double getPerimeter() {
        return getSide1()*2+getSide2()*2;
    }

    @Override
    public double getArea() {
        return getSide1()*getSide2();
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side1 = side1;
    }
}
