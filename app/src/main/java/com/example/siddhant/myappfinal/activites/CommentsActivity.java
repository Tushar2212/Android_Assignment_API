package com.example.siddhant.myappfinal.activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.siddhant.myappfinal.R;
import com.example.siddhant.myappfinal.adapters.CommentsAdapter;
import com.example.siddhant.myappfinal.api.CommentsAPI;
import com.example.siddhant.myappfinal.models.Comments;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CommentsActivity extends AppCompatActivity {
    RecyclerView commentsListView;
    CommentsAdapter commentsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        commentsListView=(RecyclerView)findViewById(R.id.CommentsRv);
        commentsListView.setLayoutManager(new LinearLayoutManager(this));
        commentsAdapter=new CommentsAdapter(this, new ArrayList<Comments>());
        commentsListView.setAdapter(commentsAdapter);

        Retrofit retrofit= new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com").
                addConverterFactory(GsonConverterFactory.create()).
                 build();
        CommentsAPI commentsAPI=retrofit.create(CommentsAPI.class);
        Callback<ArrayList<Comments>> commentsCallback= new Callback<ArrayList<Comments>>() {
            @Override
            public void onResponse(Call<ArrayList<Comments>> call, Response<ArrayList<Comments>> response) {
                commentsAdapter=new CommentsAdapter(CommentsActivity.this,response.body());
                commentsListView.setAdapter(commentsAdapter);

            }

            @Override
            public void onFailure(Call<ArrayList<Comments>> call, Throwable t) {

            }
        };
        commentsAPI.getCommentsById(getIntent().getIntExtra("postId",-1)).enqueue(commentsCallback);
    }
}
