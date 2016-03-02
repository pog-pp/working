package logic;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by paul on 02.03.16.
 */
@Entity
@Table(name="Statistics")
public class Statistics {
    private Long stid;
    private Long id;
    private Long tid;

    public Statistics(){
    }
    private Set<Test> tests = new HashSet<Test>(0);

    @OneToMany
    @JoinTable(name = "id")
    public Set<Test> getTests() {
        return tests;
    }

    private Set<Student> studs = new HashSet<Student>(0);

    @OneToMany
    @JoinTable(name = "id")
    public Set<Student> getStuds() {
        return studs;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="stid")
    public Long getStid(){
        return stid;
    }

    @Column(name="id")
    public Long getId(){
        return id;
    }

    @Column(name="tid")
    public Long getTid(){
        return tid;
    }
}
