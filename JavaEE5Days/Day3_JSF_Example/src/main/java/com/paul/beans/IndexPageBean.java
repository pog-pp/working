package com.paul.beans;

import com.paul.model.Patient;
import com.paul.service.PatientService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by paul on 16.03.16.
 */
@ManagedBean
@ViewScoped
public class IndexPageBean {

    @EJB
    private PatientService patientService;

    public List<Patient> getPatients(){
        return patientService.getAllPatients();
    }

    public void editPatient(Patient patient) throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("patient", patient);

        HttpServletResponse response = (HttpServletResponse)context.getExternalContext().getResponse();
        response.sendRedirect("edit.xhtml");
    }

    public void removePatient(Patient patient) {
        patientService.removePatient(patient);
    }
}
