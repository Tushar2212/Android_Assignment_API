package com.example.siddhant.myappfinal.activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.siddhant.myappfinal.R;
import com.example.siddhant.myappfinal.adapters.PostAdapter;
import com.example.siddhant.myappfinal.api.PostAPI;
import com.example.siddhant.myappfinal.models.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostActivity extends AppCompatActivity {
    RecyclerView postListView;
    PostAdapter postAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        postListView=(RecyclerView)findViewById(R.id.PostRv);
        postListView.setLayoutManager(new LinearLayoutManager(this));
        postAdapter=new PostAdapter(this,new ArrayList<Post>());
        postListView.setAdapter(postAdapter);

        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com").
                addConverterFactory(GsonConverterFactory.create()).
                build();
        PostAPI postAPI=retrofit.create(PostAPI.class);
        Callback<ArrayList<Post>> postCallBack=new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {


                postAdapter=new PostAdapter(PostActivity.this,response.body());
                postListView.setAdapter(postAdapter);

            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {

            }
        };
        int IdReceived = getIntent().getIntExtra("userId", -1);
        if(IdReceived!=-1)
        {
        postAPI.getPostsById(IdReceived).enqueue(postCallBack);
        }else
        {
            postAPI.getPosts().enqueue(postCallBack);
        }
    }
    }

