package com.enterthings.appretrofitunicauca.model;

import com.google.gson.annotations.SerializedName;

public class ModelPost {
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private  String title;

    public ModelPost(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
