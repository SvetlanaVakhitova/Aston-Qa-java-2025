public class BowlWithFood {

    private int foodAmount;

    public BowlWithFood(int _food) {
        this.foodAmount = _food;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    /**
     * добавление еды в миску
     * @param _amount
     */
    public void addFoodAmount(int _amount) {

        this.foodAmount += _amount;
    }

    /**
     * уменьшение еды в миске
     * @param _amount
     */
    public void decreaseFoodAmount(int _amount) {
        this.foodAmount -= _amount;
    }

}
