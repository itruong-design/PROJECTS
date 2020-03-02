package Shape;

public class Rectangle extends Parallelogram {
    double width;
    double length;
    Area obj = () -> { return width*length; };

    Rectangle(double width, double length) throws Exception{
        super(width, length);
        this.width = super.width;
        this.length = super.height;
    }

    public double getObjMethod() {
        return obj.getArea();
    }
}
