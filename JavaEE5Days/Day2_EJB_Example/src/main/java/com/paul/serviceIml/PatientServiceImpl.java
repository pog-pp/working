package com.paul.serviceIml;

import com.paul.model.Patient;
import com.paul.service.PatientService;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by paul on 16.03.16.
 */
@Stateless
public class PatientServiceImpl implements PatientService {

    public static final Class PATIENT_CLASS = Patient.class;
    @PersistenceContext(unitName = "patientsBase")
    private EntityManager em;


    public Patient findPatientById(Long id) {
        return (Patient) em.find(PATIENT_CLASS, id);
    }

    public List<Patient> getAllPatients() {
        return em.createQuery("select p from Patient p").getResultList();
    }

    public void removePatient(Patient patient) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(patient);
        transaction.commit();
    }

    public void savePatient(Patient patient) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(patient);
        transaction.commit();
    }

    public void merge(Patient patient) {

    }
}
