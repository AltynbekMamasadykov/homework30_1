package com.company.service.impl;

import com.company.dao.UserDao;
import com.company.exceptions.NoSuchIdException;
import com.company.model.User;
import com.company.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDao();


    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void findWithId(int id) {
        try{
            if(userDao.checkIfUserExist(id)){
                throw new NoSuchIdException("No user with that id");
            }userDao.findWithId(id);
        }catch (NoSuchIdException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteWithId(int id) {
        try{
            if(userDao.checkIfUserExist(id)){
                throw new NoSuchIdException("No user with that id");
            }userDao.deleteWithId(id);
        }catch (NoSuchIdException e){
            System.out.println(e.getMessage());
        }


    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
