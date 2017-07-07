package com.example.siddhant.myappfinal.api;

import com.example.siddhant.myappfinal.models.Album;
import com.example.siddhant.myappfinal.models.ToDo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by siddhant on 04-07-2017.
 */

public interface ToDoAPI {
    @GET("/todos")
    Call<ArrayList<ToDo>> getToDos();
    @GET("/users/{id}/todos")
    Call<ArrayList<ToDo>> getToDosById(
            @Path("id") int id
    );
}
