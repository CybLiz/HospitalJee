package org.example.hopitaljee.Interface;

import org.example.hopitaljee.Entity.Patient;

import java.util.List;

public interface PatientServiceInterface {
    public List<Patient> getAllPatients();
    public Patient getPatient(int id );
    public void createPatient(Patient patient);
    public void updatePatient(Patient patient);
//    public void deletePatient(int id);
}

