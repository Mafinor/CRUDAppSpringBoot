package com.ponomarev.crudappspringboot.services;

import com.ponomarev.crudappspringboot.dao.UserDao;
import com.ponomarev.crudappspringboot.exceptions.NoSuchUserException;
import com.ponomarev.crudappspringboot.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserDao<User, Long> userUserDaoImpl;

    @Autowired
    public UserServiceImpl(UserDao<User, Long> userUserDaoImpl) {
        this.userUserDaoImpl = userUserDaoImpl;
    }

    @Override
    public List<User> findAll() {
        return userUserDaoImpl.findAll();
    }

    @Override
    public User findById(Long id) {
        return userUserDaoImpl.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public User save(User user) {
        return userUserDaoImpl.save(user);
    }

    @Override
    @Transactional
    public User update(User updatedUser) {
        User user;
        try {
            user = userUserDaoImpl.update(updatedUser);
        } catch (NoSuchUserException e) {
            return null;
        }
        return user;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        try {
            userUserDaoImpl.deleteById(id);
        } catch (NoSuchUserException ignore) {
        }
    }
}
