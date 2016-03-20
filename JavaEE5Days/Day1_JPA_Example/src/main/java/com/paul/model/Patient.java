package com.paul.model;


import javax.persistence.*;
import java.util.Date;
import java.util.List;
/**
 * Created by paul on 15.03.16.
 */

    @Entity
    @Access(AccessType.FIELD)
    public class Patient {
        @Id
        @GeneratedValue
        Long id;

        String name;

        String familyName;

        @Enumerated(EnumType.ORDINAL)
        Gender gender;

        @Temporal(TemporalType.DATE)
        @Column(name = "DOB")
        Date dateOfBirth;

        @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        List patientsPills;

        public String getName() {
            return name;
        }

        public List getPatientsPills() {
            return patientsPills;
        }

        public void setPatientsPills(List patientsPills) {
            this.patientsPills = patientsPills;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setFamilyName(String familyName) {
            this.familyName = familyName;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }

        public void setDateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }
}
