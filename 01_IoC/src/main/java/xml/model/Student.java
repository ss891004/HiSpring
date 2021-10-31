package xml.model;

public class Student {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;

    public Student(Integer id, String name, String sex, Integer age) {
        //System.out.println("set property");
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Student() {
        System.out.println("Student-NoneConstructor");
    }
}
