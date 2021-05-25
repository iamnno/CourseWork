package com.example.CourseWork.service;

import com.example.CourseWork.dao.DaoFactory;
import com.example.CourseWork.model.Flat;
import com.example.CourseWork.model.User;

import java.util.Collection;
import java.util.HashMap;

public class FlatServiceImplements implements FlatService{

    DaoFactory daoFactory;

    public FlatServiceImplements(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Collection<Flat> getAllFlat() {
        return daoFactory.getFlatDao().findAll();
    }

    @Override
    public Collection<Flat> search(HashMap<String, Object> parameter) {
        if (parameter.isEmpty()) {return getAllFlat();}
        return daoFactory.getFlatDao().findByParameter(parameter);
    }

    @Override
    public Flat getFlatbyID(Integer flatID) {
        return daoFactory.getFlatDao().get(flatID);
    }

    @Override
    public void updateFlat(Flat flat) {
        daoFactory.getFlatDao().update(flat);
    }

    @Override
    public void newFlat(Flat flat, User user) {
        daoFactory.getFlatDao().addFlat(flat, user);
    }

    @Override
    public void deleteFlat(Flat flat, User user) {
        daoFactory.getFlatDao().deleteFlat(flat, user);
    }

    @Override
    public HashMap<String, Object> searchParameter(String pricefrom,
                                               String priceto,
                                               String roomsfrom,
                                               String roomsto,
                                               String animal,
                                               String metro) {
        HashMap<String, Object> parameters = new HashMap<>();

        if (pricefrom == null || pricefrom.isEmpty()) {
            parameters.put("pf", null);} else {
            parameters.put("pf", Integer.parseInt(pricefrom));
        }
        if (roomsfrom == null || roomsfrom.isEmpty()) {
            parameters.put("rf", null);} else {
            parameters.put("rf", Integer.parseInt(roomsfrom));
        }
        if (priceto == null || priceto.isEmpty()) {
            parameters.put("pt", null);} else {
            parameters.put("pt", Integer.parseInt(priceto));
        }
        if (roomsto == null || roomsto.isEmpty()) {
            parameters.put("rt", null);} else {
            parameters.put("rt", Integer.parseInt(roomsto));
        }
        if (animal == null || animal.isEmpty()) {
            parameters.put("a", null);} else {
            parameters.put("a", Boolean.parseBoolean(animal));
        }
        if (metro == null || metro.isEmpty()) {
            parameters.put("m", null);} else {
            parameters.put("m", Boolean.parseBoolean(metro));
        }

        return parameters;
    }
}
