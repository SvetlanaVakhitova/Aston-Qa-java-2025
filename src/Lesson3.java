public class Lesson3 {

    public static void main(String[] args) {

         // задание про сотдудников
        Person[] persons = new Person[5];

        persons[0] = new Person("Василий","начальник", "vasily@gmail.com","3423432432", 5000,34 );
        persons[1] = new Person("Иван","подчиненный", "ivan@gmail.com","3423432433", 7000,30 );
        persons[2] = new Person("Мария","подчиненный", "mary@gmail.com","3423432434", 8400,30 );
        persons[3] = new Person("Петр","стажёр", "petr@gmail.com","3423432435", 5500,20 );
        persons[4] = new Person("Оксана","подчиненный", "oksana@gmail.com","3423432436", 6200, 24);

        System.out.println("Список сотрудников: ");
        for (int i = 0; i < persons.length; i++) {
            persons[i].getInfo();
        }

        // задание про парк с аттаркционами
        Park.Attraction attraction1 = new Park().new Attraction("карусель", "12-18", 200);
        Park.Attraction attraction2 = new Park().new Attraction("батут", "12-18", 230);

        System.out.println();
        System.out.println("Список аттакционов: ");
        attraction1.getInfo();
        attraction2.getInfo();

    }
}
