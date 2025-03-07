import org.junit.Test;
import static org.junit.Assert.*;

public class Lesson14Test {

    @Test
    public void testFactorialZero() {
        assertEquals(1, Lesson14.factorial(0));
    }

    @Test
    public void testFactorialOne() {
        assertEquals(1, Lesson14.factorial(1));
    }

    @Test
    public void testFactorialPositive() {
        assertEquals(120, Lesson14.factorial(5));
        assertEquals(24, Lesson14.factorial(4));
        assertEquals(6, Lesson14.factorial(3));
    }

    @Test
    public void testFactorialLargeNumber() {
        assertEquals(3628800, Lesson14.factorial(10));
    }

    @Test
    public void testTriangleAreaPositive() {
        assertEquals(10.0, Lesson14.triangleArea(4.0, 5.0), 0.001);
        assertEquals(6.0, Lesson14.triangleArea(3.0, 4.0), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTriangleAreaNegativeBase() {
        Lesson14.triangleArea(-2.0, 5.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTriangleAreaNegativeHeight() {
        Lesson14.triangleArea(2.0, -5.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTriangleAreaZero() {
        Lesson14.triangleArea(0.0, 5.0);
    }

    @Test
    public void testCalculateAddition() {
        assertEquals(5, Lesson14.calculate(2, 3, '+'), 0.001);
        assertEquals(-1, Lesson14.calculate(-4, 3, '+'), 0.001);
    }

    @Test
    public void testCalculateSubtraction() {
        assertEquals(-1, Lesson14.calculate(2, 3, '-'), 0.001);
        assertEquals(1, Lesson14.calculate(4, 3, '-'), 0.001);
    }

    @Test
    public void testCalculateMultiplication() {
        assertEquals(6, Lesson14.calculate(2, 3, '*'), 0.001);
        assertEquals(-12, Lesson14.calculate(-4, 3, '*'), 0.001);
    }

    @Test
    public void testCalculateDivision() {
        assertEquals(2.0, Lesson14.calculate(6, 3, '/'));
        assertEquals(0.5, Lesson14.calculate(1, 2, '/'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateDivisionByZero() {
        Lesson14.calculate(5, 0, '/');
    }

    @Test
    public void testCompareNumbers() {
        assertEquals(0, Lesson14.compareNumbers(5, 5));
        assertEquals(0, Lesson14.compareNumbers(0, 0));
        assertEquals(0, Lesson14.compareNumbers(-3, -3));
        assertEquals(-1, Lesson14.compareNumbers(3, 5));
        assertEquals(-1, Lesson14.compareNumbers(-5, -3));
        assertEquals(-1, Lesson14.compareNumbers(-1, 1));
        assertEquals(1, Lesson14.compareNumbers(5, 3));
        assertEquals(1, Lesson14.compareNumbers(-3, -5));
        assertEquals(1, Lesson14.compareNumbers(1, -1));
    }
}
