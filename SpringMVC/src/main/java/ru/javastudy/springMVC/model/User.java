package ru.javastudy.springMVC.model;

/**
 * Created by paul on 08.03.16.
 */
import org.springframework.stereotype.Component;


@Component
public class User {

    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
