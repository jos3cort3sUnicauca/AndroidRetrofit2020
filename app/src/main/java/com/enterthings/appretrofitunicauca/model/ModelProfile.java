package com.enterthings.appretrofitunicauca.model;

import com.google.gson.annotations.SerializedName;

public class ModelProfile {

    @SerializedName("name")
    private String name;

    public ModelProfile(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
