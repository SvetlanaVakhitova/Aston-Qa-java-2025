
import java.util.Arrays;

public class Lesson2 {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        summTwoCheck(5, 10);
        printSighOfValue(-10);
        checkSignOfValue(100);
        repeatWord(3, "Солнце");
        сheckIfLeapYear(2024);
        arrayReplacement();
        massivFill();
        massivUpdate();
        massivDiagonalFill();
        generateArray(5, 345);
    }

    /*
    * 1 задание три слова в столбик
    */
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    /*
     * 2 задание проверка суммы
     */
    public static void checkSumSign() {
        int a = 10;
        int b = -20;
        if (a + b >= 0) {
            System.out.println("Сумма положительная");
            return;
        }

        System.out.println("Сумма отрицательная");

    }

    /*
    * 3 задание вывести слово по условию
    */
    public static void printColor() {
        int value = 50;
        if (value <= 0) {
            System.out.println("Красный");
        }
        if (value <= 100) {
            System.out.println("Желтый");
        }
        if (value > 100) {
            System.out.println("Зеленый");
        }
    }

    /*
     * 4 задание сравнение двух чисел
     */
    public static void compareNumbers() {
        int a = 10;
        int b = 20;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    /**
     * 5 задание сравнеение суммы двух чисел
     */
    public static boolean summTwoCheck(int a, int b) {
        if (10 <= a + b && a + b <= 20) {
            return true;
        }
        return false;
    }

    /**
     * 6 задание проверка на положительное/отрицательное (вывод)
     */
    public static void printSighOfValue(int a) {
        if (a >= 0) {
            System.out.println(a + " - положительное число");
        } else {
            System.out.println(a + " - отрицательное число");
        }
    }

    /**
     * 7 задание проверка на положительное/отрицательное (толко проверка)
     */
    public static boolean checkSignOfValue(int a) {
        if (a >= 0) {
            return true;
        }
        return false;
    }

    /**
     * 8 задание напечатать указанную строку указанное число раз
     */
    public static void repeatWord(int a, String b) {
        for (int i = 0; i < a; i++) {
            System.out.println(b);
        }
    }

    /**
     * 9 задание проверка года (високосный или нет)
     */
    public static boolean сheckIfLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }

        if (year % 100 == 0) {
            return false;
        }

        return year % 4 == 0;
    }

    /**
     * 10 задача замена элементов массива
     */
    public static void arrayReplacement() {
        int[] nums = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        for (int i = 0; i < 10; i++) {
            if (nums[i] == 1) {
                nums[i] = 0;
            } else {
                nums[i] = 1;
            }
        }
    }

    /**
     * 11 задание заполнение массива
     */
    public static void massivFill() {
        int[] nums = new int[100];
        for (int i = 0; i < 100; i++) {
            nums[i] = i + 1;
        }
    }

    /**
     * 12 задание  
     */
    public static void massivUpdate() {
        int[] nums = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 6) {
                nums[i] = nums[i] * 2;
            }
        }
    }

    /**
     * 13 задача заполнние диагонали двумерного массива
     */
    public static void massivDiagonalFill() {
        int[][] nums = new int[5][5];

        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 5; j++) {

                if (i == j) {
                    nums[i][j] = 1;
                }
            }
        }
    }

    /**
     * 14 задача создание одномерного массива с одинаковыми значениями
     */
    public static void generateArray(int len, int initialValue) {
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = initialValue;
        }
        System.out.println(Arrays.toString(nums));
    }
}
