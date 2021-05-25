package com.example.CourseWork.model;

import java.util.HashMap;

public class User {

    private Integer userID;

    private String name;

    private String login;

    private String password;

    private HashMap<Integer, Flat> myflat;

    public User(Integer userID, String name, String login, String password) {
        this.userID = userID;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public User(Integer userID, String name, String login, String password, HashMap<Integer, Flat> myflat) {
        this.userID = userID;
        this.name = name;
        this.login = login;
        this.password = password;
        this.myflat = myflat;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HashMap<Integer, Flat> getMyFlat() {
        return myflat;
    }

    public void setMyFlat(HashMap<Integer, Flat> myflat) {
        this.myflat = myflat;
    }
}
