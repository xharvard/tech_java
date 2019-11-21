package com.xhh.dp.prototype;

import java.io.IOException;

import org.junit.Test;

public class PrototypeTest {

    @Test
    public void test1() throws CloneNotSupportedException, ClassNotFoundException, IOException {
        Teacher teacher = new Teacher();
        teacher.setAge(23);
        teacher.setName("老师");

        Student student = new Student();
        student.setAge(50);
        student.setName("学生");
        student.setTeacher(teacher);

        // 浅克隆，只支持8种基本类型+String
        System.out.println("===浅克隆===");
        Student cloneStu = (Student) student.clone();
        System.out.println(student == cloneStu);
        System.out.println(student.getTeacher() == cloneStu.getTeacher());

        System.out.println("===深克隆===");
        Student deepCloneStu = (Student) student.deepClone();
        System.out.println(student == deepCloneStu);
        System.out.println(student.getTeacher() == deepCloneStu.getTeacher());
    }
}
