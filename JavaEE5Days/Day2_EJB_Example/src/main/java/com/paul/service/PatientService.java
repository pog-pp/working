package com.paul.service;

import com.paul.model.Patient;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by paul on 16.03.16.
 */
@Remote
public interface PatientService {
    public Patient findPatientById(Long id);
    public List<Patient> getAllPatients();
    public void removePatient(Patient patient);
    public void savePatient(Patient patient);

    void merge(Patient patient);
}
