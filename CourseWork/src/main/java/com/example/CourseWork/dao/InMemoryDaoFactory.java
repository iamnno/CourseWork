package com.example.CourseWork.dao;

public class InMemoryDaoFactory implements DaoFactory{

    InMemoryDatabase database;

    FlatDao flatdao;
    UserDao userdao;

    InMemoryDaoFactory(InMemoryDatabase database) {
        this.database = database;

        flatdao = new InMemoryFlatDao(database);
        userdao = new InMemoryUserDao(database);
    }

    @Override
    public UserDao getUserDao() {
        return userdao;
    }

    @Override
    public FlatDao getFlatDao() {
        return flatdao;
    }
}
