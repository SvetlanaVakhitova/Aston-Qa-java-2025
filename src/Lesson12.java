public class Lesson12 {

    public static void main(String[] args) {
        
        String[][] arr = { { "0", "1", "1", "3" }, { "0", "1", "1", "1"} }; // задаём двумерный строковый массив 
       
        String[][] arr2 = { { "0", ".", "1", "3" }, { "0", "1", "1", "в"} };  // задаём двумерный строковый массив с неверными данными

        try {
            summarizeArray(arr);
            summarizeArray(arr2);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }
        catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param arraStrings
     * @throws MyArraySizeException
     */
    public static void summarizeArray(String[][] arraStrings) throws MyArraySizeException, MyArrayDataException {

        if (arraStrings[0].length != 4 || arraStrings[1].length != 4) {
            throw new MyArraySizeException("array size now allowed");
        }

        var sum = 0;
        for (int i = 0; i < arraStrings.length; i++) {
            for (int j = 0; j < arraStrings[i].length; j++) {

                try {
                    sum+=Integer.parseInt(arraStrings[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("array data could not converted into integer at row " + i + ", column " + j);
                }
            }
        }

        System.out.println("summ of all elements in array: " + sum);
    }

}
