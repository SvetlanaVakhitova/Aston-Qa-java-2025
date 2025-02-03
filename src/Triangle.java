public class Triangle extends GeometricShape {

    int a;
    int b;
    int c;
    int h;

    String fillColor;
    String borderColor;

    public Triangle(int a, int b, int c, int h, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.a = a;
        this.b = b;
        this.c = c;
        this.h = h;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public String getName() {
        return "Треугольник";
    }

    public double calculateArea() {
        return 0.5 * (this.a * this.h);
    }

    public double calculatePerimeter() {
        return this.a + this.b + this.c;
    }

}
