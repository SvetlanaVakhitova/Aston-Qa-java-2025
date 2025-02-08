public class Cat extends Animal {

    private boolean satiety; // сытость

    private int foodAmountGetEnough;

    private static int count;

    public Cat(String _name, int foodAmountGetEnough) {
        super(_name);
        this.satiety = false;
        this.runLimit = 200;
        this.foodAmountGetEnough = foodAmountGetEnough;

        count++;
    }

    public static  int getCount(){
        return count;
    }

    /**
     * делает кота сытым (голодый он изначально, поэтому не передаём сюда false
     */
    private void setSatiety() {
        this.satiety = true;
    }

    /*
     * получает сытость
     */
    public boolean getSatiety() {
        return satiety;
    }

    /**
     * Переопределяет плавание для котов
     */
    public void swim(int $distance) {

        System.out.println(this.getName() + " не умеет плавать ");
    }

    /**
     * кормит кота из заданной миски
     * @param 
     * @param 
     */
    public void eat(BowlWithFood $bowl, int $amount) {

        // перед кормелнием проверяем, сытый ли кот
        if (this.getSatiety()) {
            System.out.println(this.getName() + " уже сытый ");
            return;
        }
        //  Если коту удалось покушать (хватило еды), сытость = true.

        // в миске с едой не должно получиться отрицательного количества еды
        if ($bowl.getFoodAmount() < $amount) {
            System.out.println("в миске осталось меньше чем пытается съесть ");
            return;
        }
        // если коту мало еды в миске, то он её просто не трогает,
        if ($bowl.getFoodAmount() < this.foodAmountGetEnough) {
            System.out.println("в миске осталось меньше, чем нужно чтобы " + this.getName() + " наелся");
            return;
        }

        if ($amount < this.foodAmountGetEnough) {
            System.out.println("предложенное количество еды меньше, чем нужно чтобы " + this.getName() + " наелся");
            return;
        }

        $bowl.decreaseFoodAmount($amount); // уменьшем количество еды в миске
        this.setSatiety(); // делаем кота сытым
        System.out.println(this.getName() + " съел " + $amount + " и наелся");
        System.out.println("в миске осталось " + $bowl.getFoodAmount());
    }

}
