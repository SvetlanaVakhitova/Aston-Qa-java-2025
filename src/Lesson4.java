public class Lesson4 {

    public static void main(String[] args) {

        int catsCount = 0;
        int dogsCount = 0;
        int animalCount = 0;

        // задаём массивы котов и собак
        Cat[] cats = new Cat[2];
        Dog[] dogs = new Dog[3];

        cats[0] = new Cat("Михаил", 120);
        cats[1] = new Cat("Финдус", 90);

        dogs[0] = new Dog("Грег");
        dogs[1] = new Dog("Арнольд");
        dogs[2] = new Dog("Эдуард");

        // запуск бега и плавания для котов
        cats[0].run(20);
        cats[0].swim(20);
        cats[1].run(240);
        cats[1].swim(50);

        // запуск бега и плавания для собак
        dogs[0].run(20);
        dogs[1].run(520);
        dogs[2].run(440);

        // подсчет созданных котов, собак и животных.
        for (int i = 0; i < cats.length; i++) {
            catsCount++;
            animalCount++;
        }

        for (int i = 0; i < dogs.length; i++) {
            dogsCount++;
            animalCount ++;
        }

        System.out.println("Итого " + catsCount + " котов, " + dogsCount + " собак," + animalCount + "животныъ");


        // Создаём миску с едой
        BowlWithFood bigBowl = new BowlWithFood(200);

        // кормим котов из созданной миски
        cats[0].eat(bigBowl, 90); 
        cats[1].eat(bigBowl, 100);

        // добавляем еды в миску, чтобы гарантированно хва
        bigBowl.addFoodAmount(120);

        // снова кормим котов
        cats[0].eat(bigBowl, 200); // ожидаем, что Василий наестся
        cats[1].eat(bigBowl, 20); // ожидаем, что Финдус уже сытый и поэтому не притронется, хотя еды в миске достаточно


        // задачние 2 (геометрические фигуры)
        GeometricShape[] geometrics = new GeometricShape[3]; // задаём массив из 3-х фигур, чтобы легче было выводить информацию

        geometrics[0] = new Triangle(1, 2, 3, 4, "red", "black");
        geometrics[1] = new Square(33, "red", "black");
        geometrics[2] = new Rectangle(12, 44, "yellow", "orange");

        // вывод результатов в консоль
        for (GeometricShape geometric : geometrics) {
            System.out.println(geometric.getName());
            System.out.println("площадь:" + geometric.calculatePerimeter());
            System.out.println("периметр:" + geometric.calculateArea());
            System.out.println("цвет фона:" + geometric.getFillColor());
            System.out.println("цвет границ:" + geometric.getBorderColor());
        }

    }
}
