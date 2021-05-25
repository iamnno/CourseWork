package com.example.CourseWork.dao;

import com.example.CourseWork.model.Flat;
import com.example.CourseWork.model.User;

import java.util.Collection;
import java.util.HashMap;

public interface FlatDao extends AbstractDao<Flat> {

    Collection<Flat> findByParameter(HashMap<String, Object> parameter);

    HashMap<Integer, Flat> findByUserID(Integer userID);

    void addFlat(Flat flat, User user);

    void deleteFlat(Flat flat, User user);
}
