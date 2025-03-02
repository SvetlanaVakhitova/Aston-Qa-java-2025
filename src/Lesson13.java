import java.util.List;
import java.util.ArrayList;

public class Lesson13 {
    public static void main(String[] args) {
        // Создаем список студентов
        List<Student> students = new ArrayList<>();

        // Студент 1 курса с отличными оценками
        Student student1 = new Student("Иван Петров", "группа1", 1);
        student1.addMark(5);
        student1.addMark(5);
        student1.addMark(5);
        students.add(student1);

        // Студент 2 курса со смешанными оценками
        Student student2 = new Student("Мария Козловская", "группа2", 2);
        student2.addMark(4);
        student2.addMark(5);
        student2.addMark(3);
        students.add(student2);

        // Студент 3 курса со средними оценками
        Student student3 = new Student("Алексей Смирнов", "группа3", 3);
        student3.addMark(4);
        student3.addMark(4);
        student3.addMark(4);
        students.add(student3);

        // Студент 1 курса с низкими оценками
        Student student4 = new Student("Елена Смирнова", "группа4", 1);
        student4.addMark(3);
        student4.addMark(2);
        student4.addMark(3);
        students.add(student4);

        Student student5 = new Student("Дмитрий Козлов", "группа5", 2);
        student5.addMark(5);
        student5.addMark(4);
        student5.addMark(5);
        students.add(student5);

        for (Student student : students) {
            System.out.println("Студент: " + student.getName());
            System.out.println("Группа: " + student.getGroup());
            System.out.println("Курс: " + student.getCourse());
            System.out.println("Оценки: " + student.getMarks());
            System.out.println("-------------------");
        }

        System.out.println("\nПосле удаления студентов с оценкой ниже 3:");
        removeBadStudents(students);

        for (Student student : students) {
            System.out.println("Студент: " + student.getName());
            System.out.println("Группа: " + student.getGroup());
            System.out.println("Курс: " + student.getCourse());
            System.out.println("Оценки: " + student.getMarks());
            System.out.println("-------------------");
        }

        printStudents(students, 1);
        printStudents(students, 2);
        printStudents(students, 3);

        // =========== Телефонный справочник ===========
        System.out.println("\nПолный справочник:");
        PhoneBook phoneBook = new PhoneBook();

        // Добавляем номера
        phoneBook.add("Иван Петров", "111-111");
        phoneBook.add("Мария Козловская", "222-222");

        // Добавляем несколько номеров для одного человека
        phoneBook.add("Алексей Смирнов", "333-111");
        phoneBook.add("Алексей Смирнов", "333-222");
        phoneBook.add("Алексей Смирнов", "333-333");

        phoneBook.add("Елена Смирнова", "444-111");
        phoneBook.add("Елена Смирнова", "444-222");

        phoneBook.add("Дмитрий Кузнецов", "555-111");
        phoneBook.add("Дмитрий Кузнецов", "555-222");
        phoneBook.add("Дмитрий Кузнецов", "555-333");
        phoneBook.add("Дмитрий Кузнецов", "555-444");

        // Выводим справочник
        for (String name : phoneBook.keySet()) {
            System.out.println(name + ": " + phoneBook.get(name));
        }
    }

    public static void removeBadStudents(List<Student> students) {
        for (int i = students.size() - 1; i >= 0; i--) {
            if (calculateAverageMark(students.get(i)) < 3) {
                students.remove(i);
            }
        }
    }

    private static double calculateAverageMark(Student student) {
        List<Integer> marks = student.getMarks();
        if (marks.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.size();
    }

    public static void printStudents(List<Student> students, int course) {
        System.out.println("\nСтуденты " + course + " курса:");
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println("Имя: " + student.getName() + ", Курс: " + student.getCourse());
            }
        }
    }

    public static boolean moveStudent(Student student) {
        if (calculateAverageMark(student) >= 3) {
            student.setCourse(student.getCourse() + 1);
            return true;
        }
        return false;
    }
}
