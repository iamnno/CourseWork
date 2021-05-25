package com.example.CourseWork.dao;

import com.example.CourseWork.model.Flat;
import com.example.CourseWork.model.User;

import java.util.Map;
import java.util.TreeMap;

public class InMemoryDatabase {

    Map<Integer, Flat> flats;

    Map<Integer, User> users;

    public InMemoryDatabase() {
        flats = new TreeMap<>();
        users = new TreeMap<>();
    }

    public DaoFactory getDaoFactory() {
        return new InMemoryDaoFactory(this);
    }
}
