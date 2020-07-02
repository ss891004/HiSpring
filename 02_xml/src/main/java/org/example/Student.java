package org.example;

public class Student {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;

    //Constructors
    public Student(Integer id , String name , String sex , Integer age){
        //System.out.println("set property");
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

}
