package com.enterthings.appretrofitunicauca.model;

import com.google.gson.annotations.SerializedName;

public class ModelComments {

    //@SerializedName("id")
    private int id;
    private String body;
    private int postId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}
