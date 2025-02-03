public class Rectangle extends GeometricShape {

    int a;
    int b;
    String fillColor;
    String borderColor;

    public Rectangle(int a, int b, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.a = a;
        this.b = b;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public String getName() {
        return "Прямоугольник";
    }


    @Override
    public double calculateArea() {
        return this.a * this.b;
    }

    @Override
    public double calculatePerimeter() {
        return (this.a + this.b) * 2;
    }
}
