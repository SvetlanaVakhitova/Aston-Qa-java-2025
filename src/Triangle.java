public class Triangle extends Shape {

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

    public double area() {
        return 0.5 * (this.a * this.h);
    }

    public double perimeter() {
        return this.a + this.b + this.c;
    }

}
