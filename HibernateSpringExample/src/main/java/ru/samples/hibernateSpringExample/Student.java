package ru.samples.hibernateSpringExample;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by paul on 03.03.16.
 */

@Entity
public class Student {
    private Long id;
    private String name;
    private Long age;

    public Student(){
        name = null;
    }

    public Student(String n, Long a){
        name = n;
        age = a;
    }

    public Student(Student s){
        name = s.getName();
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
    public Long getId() {
        return id;
    }

    @Column(name="name")
    public String getName(){
        return name;
    }

    @Column(name="age")
    public Long getAge(){
        return age;
    }

    public void setId(Long i){
        id = i;
    }

    public void setName(String s){
        name = s;
    }

    public void setAge(Long l){
        age = l;
    }
}
