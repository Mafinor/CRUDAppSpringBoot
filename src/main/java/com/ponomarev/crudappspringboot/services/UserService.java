package com.ponomarev.crudappspringboot.services;


import com.ponomarev.crudappspringboot.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User save(User user);
    User update(User updatedUser);
    void deleteById(Long id);
}
