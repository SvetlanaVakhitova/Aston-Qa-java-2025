import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class Lesson14Test {

    @Test
    public void testFactorial() {
        assertEquals(Lesson14.factorial(0), 1);
        assertEquals(Lesson14.factorial(1), 1);
        assertEquals(Lesson14.factorial(5), 120);
        assertEquals(Lesson14.factorial(10), 3628800);
    }

    @Test
    public void testTriangleArea() {
        assertEquals(Lesson14.triangleArea(4.0, 5.0), 10.0);
        assertEquals(Lesson14.triangleArea(3.0, 4.0), 6.0);
        assertEquals(Lesson14.triangleArea(2.5, 3.5), 4.375);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
          expectedExceptionsMessageRegExp = "Base and height must be positive numbers")
    public void testTriangleAreaNegative() {
        Lesson14.triangleArea(-2.0, 5.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTriangleAreaZero() {
        Lesson14.triangleArea(0.0, 5.0);
    }

    @Test
    public void testCalculateBasicOperations() {
        // Addition
        assertEquals(Lesson14.calculate(2, 3, '+'), 5.0);
        assertEquals(Lesson14.calculate(-4, 3, '+'), -1.0);
        
        // Subtraction
        assertEquals(Lesson14.calculate(5, 3, '-'), 2.0);
        assertEquals(Lesson14.calculate(-2, -3, '-'), 1.0);
        
        // Multiplication
        assertEquals(Lesson14.calculate(4, 3, '*'), 12.0);
        assertEquals(Lesson14.calculate(-2, 3, '*'), -6.0);
        
        // Division
        assertEquals(Lesson14.calculate(6, 2, '/'), 3.0);
        assertEquals(Lesson14.calculate(5, 2, '/'), 2.5);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
          expectedExceptionsMessageRegExp = "деление на ноль")
    public void testCalculateDivisionByZero() {
        Lesson14.calculate(5, 0, '/');
    }

    @Test
    public void testCompareNumbersEqual() {
        assertEquals(Lesson14.compareNumbers(5, 5), 0);
        assertEquals(Lesson14.compareNumbers(0, 0), 0);
        assertEquals(Lesson14.compareNumbers(-3, -3), 0);
        assertEquals(Lesson14.compareNumbers(3, 5), -1);
        assertEquals(Lesson14.compareNumbers(-5, -3), -1);
        assertEquals(Lesson14.compareNumbers(-1, 1), -1);
        assertEquals(Lesson14.compareNumbers(5, 3), 1);
        assertEquals(Lesson14.compareNumbers(-3, -5), 1);
        assertEquals(Lesson14.compareNumbers(1, -1), 1);
    }
}