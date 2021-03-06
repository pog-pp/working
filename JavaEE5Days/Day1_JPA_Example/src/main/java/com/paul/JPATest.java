package com.paul;

/**
 * Created by paul on 16.03.16.
 */

import com.paul.model.Gender;
import com.paul.model.Patient;
import com.paul.model.Pills;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static junit.framework.Assert.assertEquals;
public class JPATest {
    EntityManagerFactory emf;
    EntityManager em;

    @Before
    public void init() {
        emf = Persistence.createEntityManagerFactory("patientsBase");
        em = emf.createEntityManager();
    }

    @Test
    public void saveTest() {
        persistSimplePOJO();

        List results = em.createQuery("SELECT COUNT(p) FROM Patient p").getResultList();
        long size = results.isEmpty() ? 0 : (Long) results.get(0);

        assertEquals(1L, size);
    }

    @Test
    public void loadTest() {
        persistSimplePOJO();

        Patient patient = em.find(Patient.class, 1l);
        assertEquals("Mark", patient.getName());
    }

    @Test
    public void manyToManyTest() {
        persistSimplePOJO();

        Patient patient = em.find(Patient.class, 1l);
        assertEquals(2, patient.getPatientsPills().size());
    }

    @After
    public void destroy() {
        em.close();
        emf.close();
    }

    public void persistSimplePOJO() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(getPatient());
        tx.commit();
    }

    public Patient getPatient() {
        Patient patient = new Patient();
        patient.setDateOfBirth(new Date());
        patient.setGender(Gender.MALE);
        patient.setName("Mark");
        patient.setFamilyName("Tompson");

        List pills = new ArrayList();
        pills.add(new Pills("Vicodin"));
        pills.add(new Pills("Aspirin"));

        patient.setPatientsPills(pills);
        return patient;
    }
}
