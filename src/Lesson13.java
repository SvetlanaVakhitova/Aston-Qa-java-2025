import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Lesson13 {
    public static void main(String[] args) {
        // Create list of students
        List<Student> students = new ArrayList<>();

        // Student 1 - First year student with excellent marks
        Student student1 = new Student("Ivan Petrov", "group1", 1);
        student1.addMark(5);
        student1.addMark(5);
        student1.addMark(5);
        students.add(student1);

        // Student 2 - Second year student with mixed marks
        Student student2 = new Student("Maria Kozlovskaya", "group2", 2);
        student2.addMark(4);
        student2.addMark(5);
        student2.addMark(3);
        students.add(student2);

        // Student 3 - Third year student with average marks
        Student student3 = new Student("Alexey Smirnov", "group3", 3);
        student3.addMark(4);
        student3.addMark(4);
        student3.addMark(4);
        students.add(student3);

        // Student 4 - First year student with poor marks
        Student student4 = new Student("Elena Smirnova", "group4", 1);
        student4.addMark(3);
        student4.addMark(2);
        student4.addMark(3);
        students.add(student4);

        // Student 5 - Second year student with good marks
        Student student5 = new Student("Dmitry Kozlov", "QA-22", 2);
        student5.addMark(5);
        student5.addMark(4);
        student5.addMark(5);
        students.add(student5);

        // Print all students and their marks
        for (Student student : students) {
            System.out.println("Student: " + student.getName());
            System.out.println("Group: " + student.getGroup());
            System.out.println("Course: " + student.getCourse());
            System.out.println("Marks: " + student.getMarks());
            System.out.println("-------------------");
        }

        System.out.println("\nAfter removing students with average mark < 3:");
        removeBadStudents(students);

        // Print remaining students
        for (Student student : students) {
            System.out.println("Student: " + student.getName());
            System.out.println("Group: " + student.getGroup());
            System.out.println("Course: " + student.getCourse());
            System.out.println("Marks: " + student.getMarks());
            System.out.println("-------------------");
        }

        printStudents(students, 1);
        printStudents(students, 2);
        printStudents(students, 3);
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
        System.out.println("\nStudents in course " + course + ":");
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println("Name: " + student.getName() + ", Course: " + student.getCourse());
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
