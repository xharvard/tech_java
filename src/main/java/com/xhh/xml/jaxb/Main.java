package com.xhh.xml.jaxb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Main {

    public static void main(String[] args) throws Exception {
        studentTest();
    }

    public static void studentTest() throws Exception {
        // 写出
        JAXBContext context = JAXBContext.newInstance(Student.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(new Student("001", "xhh", 30), System.out);
        marshaller.marshal(new Student("002", "xhh", 30), new FileOutputStream(new File("./student.xml")));

        // 读入
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Student student = (Student) unmarshaller.unmarshal(new FileInputStream(new File("./student1.xml")));
        System.out.println(student);
    }
}
