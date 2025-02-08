public class Square extends Shape {

    int radius;
    String fillColor;
    String borderColor;

    public Square(int radius, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public String getName() {
        return "Круг";
    }

    @Override
    public double area() {
        return this.radius * this.radius * Math.PI;
    }

    @Override
    public double perimeter() {

        return 2 * Math.PI * this.radius;
    }

    public String getFillColor() {
        return fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }
}
