public class Person {
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;
    public Person(String _name, String _position, String _email, String _phone, int _salary, int _age) {

        name = _name;
        position = _position;
        email = _email;
        phone = _phone;
        salary = _salary;
        age = _age;
    }

    public void getInfo() {
        System.out.println();
        System.out.print("имя: ");
        System.out.print(this.name);
        System.out.print(", должность: ");
        System.out.print(this.position);
        System.out.print(", email: ");
        System.out.print(this.email);
        System.out.print(", телефон: ");
        System.out.print(this.phone);
        System.out.print(", зарплата: ");
        System.out.print(this.salary);
        System.out.print(", возраст: ");
        System.out.print(this.age);
    }
}
