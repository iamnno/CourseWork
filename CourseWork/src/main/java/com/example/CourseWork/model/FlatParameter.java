package com.example.CourseWork.model;

public class FlatParameter {

    private Integer price;

    private Integer rooms;

    private boolean animal;

    private boolean metro;

    public FlatParameter(Integer price, Integer rooms, boolean animal, boolean metro) {
        this.price = price;
        this.rooms = rooms;
        this.animal = animal;
        this.metro = metro;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public boolean isAnimal() {
        return animal;
    }

    public void setAnimal(boolean animal) {
        this.animal = animal;
    }

    public boolean isMetro() {
        return metro;
    }

    public void setMetro(boolean metro) {
        this.metro = metro;
    }
}
