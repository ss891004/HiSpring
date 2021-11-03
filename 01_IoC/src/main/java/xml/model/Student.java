package xml.model;


import java.beans.ConstructorProperties;

public class Student {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    //通过ConstructorProperties注解来定义参数的名称，将这个注解加在构造方法上面
    @ConstructorProperties({"id","name", "sex"})
    public Student(Integer id1, String name1, String sex1) {
        this.id = id1;
        this.name = name1;
        this.sex = sex1;
        this.age=20;
    }

    private Integer id;
    private String name;
    private String sex;
    private Integer age;

    public Student(Integer id, String name, String sex, Integer age) {
        System.out.println("Student-Constructor");
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Student() {
        System.out.println("Student-NoneConstructor");
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
