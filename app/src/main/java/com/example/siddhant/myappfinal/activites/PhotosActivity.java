package com.example.siddhant.myappfinal.activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.siddhant.myappfinal.R;
import com.example.siddhant.myappfinal.adapters.PhotosAdapter;
import com.example.siddhant.myappfinal.api.PhotosAPI;
import com.example.siddhant.myappfinal.models.Photos;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PhotosActivity extends AppCompatActivity {
    RecyclerView commentsList;
    PhotosAdapter photosAdapter;
    public static final String TAG="PhotosActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: " + getIntent().getIntExtra("userId",-1));
        Log.d(TAG, "!!!!!!!!!!!!!onCreatePhotosActivity:!!!!!!!!!!!!!!" );
        setContentView(R.layout.activity_photos);
        commentsList=(RecyclerView)findViewById(R.id.PhotosRv);
        commentsList.setLayoutManager(new LinearLayoutManager(this));
        photosAdapter=new PhotosAdapter(this, new ArrayList<Photos>());
        commentsList.setAdapter(photosAdapter);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com").
                addConverterFactory(GsonConverterFactory.create()).
                build();
        PhotosAPI photosAPI=retrofit.create(PhotosAPI.class);
        Callback<ArrayList<Photos>> photosCallback= new Callback<ArrayList<Photos>>() {
            @Override
            public void onResponse(Call<ArrayList<Photos>> call, Response<ArrayList<Photos>> response) {
                Log.d(TAG, "!!!!!!!!!!!!!!!!!!onResponse: " +response);
                photosAdapter=new PhotosAdapter(PhotosActivity.this,response.body());
                commentsList.setAdapter(photosAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Photos>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + call.request());
                Log.d(TAG, "!!!!!!!!!!!!!!!!!!!!!!!!onFailure: " + t.getMessage());
            }
        };
        Log.d(TAG, "!!!!!IdRECIEVED: "+ getIntent().getIntExtra("albumId",-1));
        photosAPI.getPhotosByIdName(getIntent().getIntExtra("albumId",-1)).enqueue(photosCallback);

    }
}
