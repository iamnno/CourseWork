package com.example.CourseWork.dao;

import com.example.CourseWork.model.Flat;
import com.example.CourseWork.model.FlatDescription;
import com.example.CourseWork.model.FlatParameter;
import com.example.CourseWork.model.User;

import java.util.Arrays;
import java.util.List;

public class InMemoryTestDao {

    public static void generateTo(InMemoryDatabase database) {

        database.users.clear();
        database.flats.clear();

        User test1 = new User(1, "test1", "test1@example.com", "test1");

        User test2 = new User(2, "test2", "test2@example.com", "test2");

        User test3 = new User(3, "test3", "test3@example.com", "test3");

        User test4 = new User(4, "test4", "test4@example.com", "test4");

        List<User> users = Arrays.asList(test1, test2, test3, test4);
        users.forEach(user -> database.users.put(user.getUserID(), user));

        Flat flat1 = new Flat(1, test1.getUserID(), new FlatDescription("Title test1 flat1", "Text test1 flat1",
                test1.getName(), "admin@gmail.com"), new FlatParameter(20000, 4, false, false), false);

        Flat flat2 = new Flat(2, test2.getUserID(), new FlatDescription("Title test2 flat2", "Text test2 flat2",
                test2.getName(), "admin@gmail.com"), new FlatParameter(7000, 1, false, false), true);

        Flat flat3 = new Flat(3, test3.getUserID(), new FlatDescription("Title test3 flat3", "Text test3 flat3",
                test3.getName(), "admin@gmail.com"), new FlatParameter(4000, 1, false, true), false);

        Flat flat4 = new Flat(4, test4.getUserID(), new FlatDescription("Title test4 flat4", "Text test4 flat4",
                test4.getName(), "admin@gmail.com"), new FlatParameter(25000, 6, false, true), true);

        Flat flat5 = new Flat(5, test1.getUserID(), new FlatDescription("Title test1 flat5", "Text test1 flat5",
                test1.getName(), "admin@gmail.com"), new FlatParameter(16000, 3, true, false), false);

        Flat flat6 = new Flat(6, test1.getUserID(), new FlatDescription("Title test1 flat6", "Text test1 flat6",
                test1.getName(), "admin@gmail.com"), new FlatParameter(5000, 1, true, false), true);

        Flat flat7 = new Flat(7, test1.getUserID(), new FlatDescription("Title test1 flat7", "Text test1 flat7",
                test1.getName(), "admin@gmail.com"), new FlatParameter(26000, 11, true, true), false);

        Flat flat8 = new Flat(8, test2.getUserID(), new FlatDescription("Title test2 flat8", "Text test2 flat8",
                test2.getName(), "admin@gmail.com"), new FlatParameter(4500, 1, true, true), true);

        List<Flat> flats = Arrays.asList(flat1, flat2, flat3, flat4, flat5, flat6, flat7, flat8);
        flats.forEach(flat -> database.flats.put(flat.getFlatID(), flat));

        users.stream()
                .forEach(user -> user.setMyFlat(database.getDaoFactory().getFlatDao().findByUserID(user.getUserID())));
    }
}
