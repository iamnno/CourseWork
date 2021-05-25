package com.example.CourseWork.model;

public class Flat {

    private Integer flatID;

    private Integer userID;

    private FlatDescription FlatD;

    private FlatParameter FlatP;

    private boolean available;

    public Flat(Integer flatID, Integer userID, FlatDescription FlatD, FlatParameter FlatP, boolean available) {
        this.flatID = flatID;
        this.userID = userID;
        this.FlatD = FlatD;
        this.FlatP = FlatP;
        this.available = available;
    }

    public Flat(Integer userID, FlatDescription FlatD, FlatParameter FlatP, boolean available) {
        this.userID = userID;
        this.FlatD = FlatD;
        this.FlatP = FlatP;
        this.available = available;
    }

    public Integer getFlatID() {
        return flatID;
    }

    public void setFlatID(Integer flatID) {
        this.flatID = flatID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public FlatDescription getFlatD() {
        return FlatD;
    }

    public void setFlatD(FlatDescription FlatD) {
        this.FlatD = FlatD;
    }

    public FlatParameter getFlatP() {
        return FlatP;
    }

    public void setFlatP(FlatParameter FlatP) {
        this.FlatP = FlatP;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
