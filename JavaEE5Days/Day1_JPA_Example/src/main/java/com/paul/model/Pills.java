package com.paul.model;


import javax.persistence.*;
/**
 * Created by paul on 16.03.16.
 */
@Entity
@Access(AccessType.FIELD)
public class Pills {
    @Id
    @GeneratedValue
    Long id;

    String title;

    public Pills(String title) {
        this.title = title;
    }

    public Pills() {
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
