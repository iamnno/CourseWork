package com.example.CourseWork.service;

import com.example.CourseWork.dao.DaoFactory;
import com.example.CourseWork.model.User;

import java.util.function.UnaryOperator;

public class UserServiceImplements implements UserService {

    DaoFactory daoFactory;

    UnaryOperator<String> passHasher;

    public UserServiceImplements(DaoFactory daoFactory, UnaryOperator<String> passHasher) {
        this.daoFactory = daoFactory;
        this.passHasher = passHasher;
    }

    @Override
    public User getByLogin(String login) {
        return daoFactory.getUserDao().getByLogin(login);
    }

    @Override
    public boolean checkPass(User user, String password) {
        return user.getPassword().equals(passHasher.apply(password));
    }

    @Override
    public User getByID(Integer userID) {
        return daoFactory.getUserDao().get(userID);
    }

    @Override
    public void newUser(User user) {
        daoFactory.getUserDao().newUser(user);
    }

    @Override
    public boolean checkUser(String name) {
        if (daoFactory.getUserDao().getByLogin(name) == null) {return false;}
        return true;
    }
}
