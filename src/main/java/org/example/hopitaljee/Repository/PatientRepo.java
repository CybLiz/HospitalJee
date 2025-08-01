package org.example.hopitaljee.Repository;
import org.hibernate.Session;

import java.util.List;
import org.example.hopitaljee.Entity.Patient;

public class PatientRepo extends Repository<Patient>{
    public PatientRepo(Session session) {
        super(session);
    }

    @Override
    public List<Patient> findAll() {
        return _session.createQuery("from Patient").list();
    }

    @Override
    public Patient findOneById(int id) {
        return _session.get(Patient.class, id);
    }


}
