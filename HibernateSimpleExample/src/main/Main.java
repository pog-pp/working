package main;

import DAO.Factory;
import logic.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by paul on 02.03.16.
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        //Создадим двух студентов
        Student s1 = new Student();
        Student s2 = new Student();

        //Проинициализируем их
        s1.setName("Ivanov Ivan");
        s1.setAge(21l);
        s2.setName("Petrova Alisa");
        s2.setAge(24l);

        //Сохраним их в бд, id будут сгенерированы автоматически
        Factory.getInstance().getStudentDAO().addStudent(s1);
        Factory.getInstance().getStudentDAO().addStudent(s2);

        //Выведем всех студентов из бд
        List<Student> studs = Factory.getInstance().getStudentDAO().getAllStudents();
        System.out.println("========Все студенты=========");
        for(int i = 0; i < studs.size(); ++i) {
            System.out.println("Имя студента : " + studs.get(i).getName() + ", Возраст : " + studs.get(i).getAge() +",  id : " + studs.get(i).getId());
            System.out.println("=============================");
        }
    }
}
