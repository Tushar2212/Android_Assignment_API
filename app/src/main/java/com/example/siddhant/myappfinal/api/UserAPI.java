package com.example.siddhant.myappfinal.api;

import com.example.siddhant.myappfinal.models.Post;
import com.example.siddhant.myappfinal.models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by siddhant on 03-07-2017.
 */

public interface UserAPI {
    @GET("/users")
    Call<ArrayList<User>> getUsers();
    interface PostsAPI{
        @GET("/users/{userId}/posts")
        Call<ArrayList<Post>> getPostsByUserId();
    }
}