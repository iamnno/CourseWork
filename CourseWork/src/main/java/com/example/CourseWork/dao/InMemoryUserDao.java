package com.example.CourseWork.dao;

import com.example.CourseWork.model.Flat;
import com.example.CourseWork.model.User;

class InMemoryUserDao extends InMemoryAbstractDao<User> implements UserDao {

    InMemoryUserDao(InMemoryDatabase database) {
        super(database.users, User::getUserID, User::setUserID, database);
    }

    @Override
    public User getByLogin(String login) {
        return database.users.values()
                .stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addFlat(User user, Flat flat) {
        user.getMyFlat().put(flat.getFlatID(), flat);
    }

    @Override
    public void deleteFlat(User user, Flat flat) {
        user.getMyFlat().remove(flat.getFlatID());
    }

    @Override
    public void newUser(User user) {
        this.insert(user, true);
        user.setUserID(this.getByLogin(user.getLogin()).getUserID());
    }
}
