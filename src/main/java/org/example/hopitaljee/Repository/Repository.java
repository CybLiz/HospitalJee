package org.example.hopitaljee.Repository;

import org.hibernate.Session;

import java.util.List;


    public abstract class Repository<T> {
        protected Session _session;
        public Repository(Session session) {
            _session = session;
        }

        abstract List<T> findAll();

        abstract T findOneById(int id);

        public void create(T o){
            _session.persist(o);
        };

        public void update(T o){
            _session.merge(o);
        };

        public void delete(T o){
            _session.remove(o);
        }


    }
