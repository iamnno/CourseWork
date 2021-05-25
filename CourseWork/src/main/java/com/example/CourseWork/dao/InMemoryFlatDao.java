package com.example.CourseWork.dao;

import com.example.CourseWork.model.Flat;
import com.example.CourseWork.model.FlatParameter;
import com.example.CourseWork.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

class InMemoryFlatDao extends InMemoryAbstractDao<Flat> implements FlatDao {

    InMemoryFlatDao(InMemoryDatabase database) {
        super(database.flats, Flat::getFlatID, Flat::setFlatID, database);
    }

    @Override
    public Collection<Flat> findByParameter(HashMap<String, Object> parameter) {
        return database.flats.values()
                .stream()
                .filter(flat -> parameterCheck(flat, parameter))
                .collect(Collectors.toList());
    }

    private static boolean parameterCheck(Flat flat, HashMap<String, Object> parameter) {
        FlatParameter flatparameter = flat.getFlatP();

        if (parameter.get("pf") != null &&
                (Integer) parameter.get("pf") > flatparameter.getPrice()) {
            return false;}
        if (parameter.get("pt") != null &&
                (Integer) parameter.get("pt") < flatparameter.getPrice()) {
            return false;}

        if (parameter.get("rf") != null &&
                (Integer) parameter.get("rf") > flatparameter.getRooms()) {
            return false;}
        if (parameter.get("rt") != null &&
                (Integer) parameter.get("rt") < flatparameter.getRooms()) {
            return false;}

        if (parameter.get("a") != null &&
                (Boolean) parameter.get("a") != flatparameter.isAnimal()) {
            return false;}

        if (parameter.get("m") != null &&
                (Boolean) parameter.get("m") != flatparameter.isMetro()) {
            return false;}

        return true;
    }

    @Override
    public HashMap<Integer, Flat> findByUserID(Integer userID) {
        return database.flats.values()
                .stream()
                .filter(Flat -> Flat.getUserID().equals(userID))
                .collect(Collectors.toMap(Flat::getFlatID, Function.identity(), (prev, next) -> next, HashMap::new));
    }

    @Override
    public void addFlat(Flat flat, User user) {
        this.insert(flat, true);
        flat.setFlatID(this.idGetter.apply(flat));
        HashMap newflat = findByUserID(user.getUserID());
        user.setMyFlat(newflat);
    }

    @Override
    public void deleteFlat(Flat flat, User user) {
        this.delete(flat);
        HashMap newflat = findByUserID(user.getUserID());
        user.setMyFlat(newflat);
    }
}
