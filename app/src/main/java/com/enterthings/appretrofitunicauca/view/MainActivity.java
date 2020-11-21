package com.enterthings.appretrofitunicauca.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.enterthings.appretrofitunicauca.R;
import com.enterthings.appretrofitunicauca.model.ModelComments;
import com.enterthings.appretrofitunicauca.model.ModelDB;
import com.enterthings.appretrofitunicauca.model.ModelPost;
import com.enterthings.appretrofitunicauca.model.ModelProfile;
import com.enterthings.appretrofitunicauca.networking.GetDataService;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textOne, textDos, textTres;

    private Retrofit mRetrofit;
    private HttpLoggingInterceptor mInterceptor;
    private OkHttpClient.Builder mOkBuilder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idAdd();
        lanzarServicio();
    }
    public void idAdd(){
        textOne = findViewById(R.id.tv_data);
        textDos = findViewById(R.id.tv_dataDos);
        textTres = findViewById(R.id.tv_dataTres);
    }

    public void  lanzarServicio(){
        mInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        mOkBuilder = new OkHttpClient.Builder().addInterceptor(mInterceptor);

        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://my-json-server.typicode.com/typicode/demo/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(mOkBuilder.build())
                .build();

        GetDataService client = mRetrofit.create(GetDataService.class);
        Call<ModelProfile> callProfile = client.getProfile();
        callProfile.enqueue(new Callback<ModelProfile>() {
            @Override
            public void onResponse(Call<ModelProfile> call, Response<ModelProfile> response) {
                textOne.setText(response.body().getName());
            }
            @Override
            public void onFailure(Call<ModelProfile> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error en Profile Service", Toast.LENGTH_SHORT).show();

            }
        });


        Call<List<ModelComments>> callComments = client.getComments();
        callComments.enqueue(new Callback<List<ModelComments>>() {
            @Override
            public void onResponse(Call<List<ModelComments>> call, Response<List<ModelComments>> response) {

                textDos.setText(String.valueOf(response.body().get(0).getBody()));
            }
            @Override
            public void onFailure(Call<List<ModelComments>> call, Throwable t) {

            }
        });

        Call<ModelDB> callDb =  client.getDb();
        callDb.enqueue(new Callback<ModelDB>() {
            @Override
            public void onResponse(Call<ModelDB> call, Response<ModelDB> response) {
                textTres.setText(String.valueOf(response.body().getDataPosts().get(1).getTitle()));
            }

            @Override
            public void onFailure(Call<ModelDB> call, Throwable t) {

            }
        });



    }
}