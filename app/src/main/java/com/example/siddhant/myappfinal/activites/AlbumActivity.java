package com.example.siddhant.myappfinal.activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.siddhant.myappfinal.R;
import com.example.siddhant.myappfinal.adapters.AlbumAdapter;
import com.example.siddhant.myappfinal.api.AlbumAPI;
import com.example.siddhant.myappfinal.models.Album;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AlbumActivity extends AppCompatActivity {
    RecyclerView AlbumRv;
    AlbumAdapter albumAdapter;
    public static final String TAG=" ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        Log.d(TAG, "!!!!!!!!onCreateAlbumActivity: ");
        AlbumRv=(RecyclerView)findViewById(R.id.AlbumRv);
        AlbumRv.setLayoutManager(new LinearLayoutManager(this));
        albumAdapter=new AlbumAdapter(this,new ArrayList<Album>());
        AlbumRv.setAdapter(albumAdapter);

        Retrofit retrofit= new Retrofit.Builder().
                baseUrl("https://jsonplaceholder.typicode.com").
                addConverterFactory(GsonConverterFactory.create()).
                build();
        AlbumAPI albumAPI=retrofit.create(AlbumAPI.class);
        Callback<ArrayList<Album>> albumCallback=new Callback<ArrayList<Album>>() {
            @Override
            public void onResponse(Call<ArrayList<Album>> call, Response<ArrayList<Album>> response) {
                Log.d(TAG, "!!!!!!!!!!!!onResponseAlbumActivity: ");
                albumAdapter.updateAlbums(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Album>> call, Throwable t) {

            }
        };
        albumAPI.getAlbum().enqueue(albumCallback);
    }
}
