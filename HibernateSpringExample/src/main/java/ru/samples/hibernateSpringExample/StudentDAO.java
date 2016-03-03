package ru.samples.hibernateSpringExample;

import java.util.Collection;

/**
 * Created by paul on 03.03.16.
 */
public interface StudentDAO {
    Student get(Long id);

    Student save(Student stud);

    Collection<Student> find(String text);

}
