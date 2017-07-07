package com.example.siddhant.myappfinal.api;

import com.example.siddhant.myappfinal.models.Album;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by siddhant on 03-07-2017.
 */

public interface AlbumAPI {
    @GET("/albums")
    Call<ArrayList<Album>> getAlbum();
}
