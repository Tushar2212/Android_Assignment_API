package com.example.siddhant.myappfinal.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.siddhant.myappfinal.R;
import com.example.siddhant.myappfinal.adapters.PostAdapter;
import com.example.siddhant.myappfinal.adapters.UserAdapter;
import com.example.siddhant.myappfinal.api.PostAPI;
import com.example.siddhant.myappfinal.api.UserAPI;
import com.example.siddhant.myappfinal.models.Post;
import com.example.siddhant.myappfinal.models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserActivity extends AppCompatActivity {
    RecyclerView rvUser;
    UserAdapter userAdapter;
    Button btnToPost,btnToToDo;
    public static final String TAG=" ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "!!!!!!!!!onCreate:User!!!!!!!!");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        rvUser=(RecyclerView)findViewById(R.id.UserRv);
        btnToPost=(Button)findViewById(R.id.btnToPost);
       btnToToDo=(Button)findViewById(R.id.btnToToDo);
        rvUser.setLayoutManager(new LinearLayoutManager(this));
        userAdapter=new UserAdapter(this,new ArrayList<User>());
        rvUser.setAdapter(userAdapter);
        Retrofit retrofit= new Retrofit.Builder().
                baseUrl("https://jsonplaceholder.typicode.com").
                addConverterFactory(GsonConverterFactory.create()).build();
        UserAPI userAPI=retrofit.create(UserAPI.class);

        Callback<ArrayList<User>> userCallBack=new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                Log.d(TAG, "!!!!!!onResponse:User!! ");
                userAdapter.updateUsers(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {

            }

        };
        userAPI.getUsers().enqueue(userCallBack);
    }

}
