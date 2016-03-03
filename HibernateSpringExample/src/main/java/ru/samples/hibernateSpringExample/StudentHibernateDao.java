package ru.samples.hibernateSpringExample;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.Collection;

/**
 * Created by paul on 03.03.16.
 */
public class StudentHibernateDao extends HibernateDaoSupport implements StudentDAO {
    public Student get(Long id) {
        return (Student) getSession().get(Student.class, id);
    }
    @Override
    protected HibernateTemplate createHibernateTemplate(SessionFactory sessionFactory) {
        HibernateTemplate result = super.createHibernateTemplate(sessionFactory);
        result.setAllowCreate(false);
        return result;
    }

    public StudentHibernateDao() {
    }
    public Student save(Student stud) {
        getSession().saveOrUpdate(stud);
        return stud;
    }
    @SuppressWarnings("unchecked")
    public Collection<Student> find(String text) {
        return getSession().createQuery("from Student s where s.name like :name").setString("name", text).list();
    }
}
