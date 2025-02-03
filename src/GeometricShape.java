abstract public class GeometricShape implements PerimeterGeometric, AreaGeometric {

    String $fillColor;
    String $borderColor;

    public String getName() {
        return null;
    }

    public GeometricShape(String $fillColor, String $borderColor) {

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
