public class Animal {

    String name;

    protected static int count;
    // ограничения
    protected int swimLimit;
   protected int runLimit;

    public Animal(String _name) {

        name = _name;
        count++;
    }

    public static  int getCount(){
        return count;
    }

    public String getName() {
        return name;
    }
   
    public void run(int $distance) {

        if($distance > this.runLimit) {
            System.out.println(this.getName() + " не может пробежать больше чем " + this.runLimit);
            return;
        }
        System.out.println(this.getName() + " пробежал " + $distance);
    }

    public void swim(int $distance) {
        if($distance > this.swimLimit) {
            System.out.println(this.getName() + " runs limit exceeded" + this.swimLimit);
            return;
        }
        System.out.println(this.getName() + "swimming " + $distance);
    }
}
