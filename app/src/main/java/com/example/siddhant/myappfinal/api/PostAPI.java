package com.example.siddhant.myappfinal.api;

import com.example.siddhant.myappfinal.models.*;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by siddhant on 02-07-2017.
 */

public interface PostAPI {
    @GET("/posts")
    Call<ArrayList<Post>> getPosts ();
    @GET("/users/{id}/posts")
    Call<ArrayList<Post>> getPostsById(
            @Path("id") int id
    );
}
