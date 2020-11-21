package com.enterthings.appretrofitunicauca.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelDB {

    @SerializedName("posts")
    private List<ModelPost> dataPosts;
    @SerializedName("comments")
    private List<ModelComments> dataComments;
    @SerializedName("profile")
    private ModelProfile dataProfile;

    public List<ModelPost> getDataPosts() {
        return dataPosts;
    }

    public void setDataPosts(List<ModelPost> dataPosts) {
        this.dataPosts = dataPosts;
    }

    public List<ModelComments> getDataComments() {
        return dataComments;
    }

    public void setDataComments(List<ModelComments> dataComments) {
        this.dataComments = dataComments;
    }

    public ModelProfile getDataProfile() {
        return dataProfile;
    }

    public void setDataProfile(ModelProfile dataProfile) {
        this.dataProfile = dataProfile;
    }
}
