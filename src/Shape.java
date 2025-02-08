abstract public class Shape implements GeometricShape {

    String $fillColor;
    String $borderColor;

    public String getName() {
        return null;
    }

    public Shape(String $fillColor, String $borderColor) {

        this.$fillColor = $fillColor;
        this.$borderColor = $borderColor;
    }

    public String getFillColor() {
        return this.$fillColor;
    }

    public String getBorderColor() {
        return this.$borderColor;
    }
}
