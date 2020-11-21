package com.enterthings.appretrofitunicauca.networking;

import com.enterthings.appretrofitunicauca.model.ModelComments;
import com.enterthings.appretrofitunicauca.model.ModelDB;
import com.enterthings.appretrofitunicauca.model.ModelProfile;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

public interface GetDataService {

    //https://my-json-server.typicode.com/typicode/demo/

    @GET("profile")
    Call<ModelProfile>getProfile();

    @GET("profile/{id}")
    Call<ModelProfile>getProfileId(@Path("id") int id);

    @GET ("comments")
    Call<List<ModelComments>>getComments();

    @GET("db")
    Call<ModelDB>getDb();



}
