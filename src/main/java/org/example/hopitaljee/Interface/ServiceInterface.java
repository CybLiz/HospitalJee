package org.example.hopitaljee.Interface;

import java.util.List;

public interface ServiceInterface<T> {
    List<T> getAll();
    void add(T element);
    T get( int id);
    void delete(int id);
    void update(int id, T element);
}


