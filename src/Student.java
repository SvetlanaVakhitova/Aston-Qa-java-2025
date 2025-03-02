import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> marks;

    // Constructor
    public Student(String name, String group, int course) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.marks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void addMark(int mark) {
        marks.add(mark);
    }

}