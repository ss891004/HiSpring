package xml;

import xml.model.Student;

public class StudentStaticFactory {

    /**
     * 静态无参方法创建UserModel
     *
     * @return
     */
    public static Student buildStudent1() {
        System.out.println(StudentStaticFactory.class + ".buildUser1()");
        Student userModel = new Student();
        userModel.setName("我是无参静态构造方法创建的!");
        return userModel;
    }
    /**
     * 静态有参方法创建UserModel
     *
     * @param name 名称
     * @param age  年龄
     * @return
     */
    public static Student buildStudent1(String name, int age) {
        System.out.println(StudentStaticFactory.class + ".buildUser2()");
        Student userModel = new Student();
        userModel.setName(name);
        userModel.setAge(age);
        return userModel;
    }


}
