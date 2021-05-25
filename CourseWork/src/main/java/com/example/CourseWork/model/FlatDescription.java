package com.example.CourseWork.model;

public class FlatDescription{

    private String title;

    private String text;

    private String ownername;

    private String contact;

    public FlatDescription(String title, String text, String ownername, String contact) {
        this.title = title;
        this.text = text;
        this.ownername = ownername;
        this.contact = contact;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
