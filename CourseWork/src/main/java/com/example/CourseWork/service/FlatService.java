package com.example.CourseWork.service;

import com.example.CourseWork.model.Flat;
import com.example.CourseWork.model.User;

import java.util.Collection;
import java.util.HashMap;

public interface FlatService {

    Collection<Flat> getAllFlat();

    Collection<Flat> search(HashMap<String, Object> parameter);

    Flat getFlatbyID(Integer flatID);

    void deleteFlat(Flat flat, User user);

    void updateFlat(Flat flat);

    void newFlat(Flat flat, User user);

    HashMap <String, Object> searchParameter(String pricefrom,
                                             String priceto,
                                             String roomsfrom,
                                             String roomsto,
                                             String animal,
                                             String metro);
}