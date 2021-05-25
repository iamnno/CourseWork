package com.example.CourseWork.service;

import com.example.CourseWork.model.User;

public interface UserService {

    User getByLogin(String login);

    User getByID(Integer userID);

    boolean checkPass(User user, String password);

    void newUser(User user);

    boolean checkUser(String name);
}
