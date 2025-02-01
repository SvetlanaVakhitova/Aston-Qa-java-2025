public class Park {

    public class Attraction {
        private String name;
        private String workTime;
        private int price;

        public Attraction(String name, String workTime, int price) {
            this.name = name;
            this.workTime = workTime;
            this.price = price;
        }

        public void getInfo() {
            System.out.println();
            System.out.print("название: ");
            System.out.print(this.name);
            System.out.print(", время работы: ");
            System.out.print(this.workTime);
            System.out.print(", стоимость: ");
            System.out.print(this.price);
        }
    }
}
