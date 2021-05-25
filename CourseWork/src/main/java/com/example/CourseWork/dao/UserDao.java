package com.example.CourseWork.dao;

import com.example.CourseWork.model.Flat;
import com.example.CourseWork.model.User;

public interface UserDao extends AbstractDao<User> {

    User getByLogin(String login);

    void addFlat(User user, Flat flat);

    void deleteFlat(User user, Flat flat);

    void newUser(User user);
}
