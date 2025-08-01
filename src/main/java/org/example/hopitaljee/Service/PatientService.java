package org.example.hopitaljee.Service;

import org.hibernate.SessionFactory;
import org.example.hopitaljee.Entity.Patient;
import org.example.hopitaljee.Interface.PatientServiceInterface;
import org.example.hopitaljee.Repository.PatientRepo;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class PatientService implements PatientServiceInterface {
    private PatientRepo patientRepo;
    private SessionFactory _sessionFactory;
    private Session session;

    public PatientService(SessionFactory sessionFactory) {
        this._sessionFactory = sessionFactory;
    }

public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<Patient>();
        session = _sessionFactory.openSession();
        patientRepo = new PatientRepo(session);
        try {
            patients = patientRepo.findAll();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return patients ;

    }

        public Patient getPatient(int id ){
        Patient patient = null;
        session = _sessionFactory.openSession();
        patientRepo = new PatientRepo(session);
        try {
            patient = patientRepo.findOneById(id);
        }catch(Exception e){
        e.printStackTrace();
        }finally {
        session.close();
        }
        return patient;
       }

    public void createPatient(Patient patient) {
        session = _sessionFactory.openSession();
        session.beginTransaction();
        patientRepo =  new PatientRepo(session);
        try {
            patientRepo.create(patient);
            session.getTransaction().commit();
        }catch(Exception e){
            try {
                session.getTransaction().rollback();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }finally {
            session.close();
        }
    }

    public void updatePatient(Patient patient) {
        session = _sessionFactory.openSession();
        session.beginTransaction();
        patientRepo =  new PatientRepo(session);
        try {
            patientRepo.update(patient);
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }



}
