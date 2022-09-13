package com.ponomarev.crudappspringboot.dao;


import com.ponomarev.crudappspringboot.exceptions.NoSuchUserException;

import java.util.List;
import java.util.Optional;

public interface UserDao<T, K extends Number> {
    T save(T object);
    List<T> findAll();
    Optional<T> findById(K id);
    T update(T updatedObject) throws NoSuchUserException;
    void deleteById(K id) throws NoSuchUserException;
}
