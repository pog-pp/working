package ru.samples.hibernateSpringExample;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by paul on 03.03.16.
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "applicationContext.xml" }, true);
        StudentDAO studDao = (StudentDAO) context.getBean("dataDao");
        Student data1 = new Student("Alex",20l);
        studDao.save(data1);
        Student data2 = new Student("Bob",22l);
        studDao.save(data2);
        Student data3 = new Student("Alice", 19l);
        studDao.save(data3);
        System.out.println(studDao.find("A%").size());
    }
}
