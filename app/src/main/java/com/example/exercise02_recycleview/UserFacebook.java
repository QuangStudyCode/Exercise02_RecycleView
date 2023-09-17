package com.example.exercise02_recycleview;

import java.time.LocalDateTime;
import java.util.Date;

public class UserFacebook {

    private int avataUser;
    private String nameUser;

    private String description;

    private String time;

    private int imageContent;

    public UserFacebook(int avataUser, String nameUser, String description, String time, int imageContent) {
        this.avataUser = avataUser;
        this.nameUser = nameUser;
        this.description = description;
        this.time = time;
        this.imageContent = imageContent;
    }

    public UserFacebook() {

    }

    public int getAvataUser() {
        return avataUser;
    }

    public void setAvataUser(int avataUser) {
        this.avataUser = avataUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImageContent() {
        return imageContent;
    }

    public void setImageContent(int imageContent) {
        this.imageContent = imageContent;
    }
}

