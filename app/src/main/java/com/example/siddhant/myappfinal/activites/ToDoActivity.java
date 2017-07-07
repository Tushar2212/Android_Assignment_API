package com.example.siddhant.myappfinal.activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.ArrayAdapter;

import com.example.siddhant.myappfinal.R;
import com.example.siddhant.myappfinal.adapters.ToDoAdapter;
import com.example.siddhant.myappfinal.api.ToDoAPI;
import com.example.siddhant.myappfinal.models.ToDo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ToDoActivity extends AppCompatActivity {
    RecyclerView ToDoRv;
    ToDoAdapter toDoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do2);
        ToDoRv=(RecyclerView)findViewById(R.id.ToDoRv);
        ToDoRv.setLayoutManager(new LinearLayoutManager(this));
        toDoAdapter=new ToDoAdapter(this,new ArrayList<ToDo>());
        ToDoRv.setAdapter(toDoAdapter);

        Retrofit retrofit= new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com").
                addConverterFactory(GsonConverterFactory.create()).
                build();
        ToDoAPI toDoAPI=retrofit.create(ToDoAPI.class);
        Callback<ArrayList<ToDo>> toDoCallback= new Callback<ArrayList<ToDo>>() {
            @Override
            public void onResponse(Call<ArrayList<ToDo>> call, Response<ArrayList<ToDo>> response) {
                toDoAdapter.updateToDo(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<ToDo>> call, Throwable t) {

            }
        };
        int idRecieved=getIntent().getIntExtra("userId",-1);
        if(idRecieved != -1)
        {
        toDoAPI.getToDosById(idRecieved).enqueue(toDoCallback);
        }else{
        toDoAPI.getToDos().enqueue(toDoCallback);
    }
    }
}
