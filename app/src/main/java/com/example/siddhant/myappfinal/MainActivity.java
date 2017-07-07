package com.example.siddhant.myappfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.siddhant.myappfinal.activites.AlbumActivity;
import com.example.siddhant.myappfinal.activites.PostActivity;
import com.example.siddhant.myappfinal.activites.ToDoActivity;
import com.example.siddhant.myappfinal.activites.UserActivity;

public class MainActivity extends AppCompatActivity {
    public static final String TAG=" ";
 TextView btnUsers,btnPosts,btnAlbums,btnTodos,btnToToDo,btnToPost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnUsers=(Button)findViewById(R.id.btnUsers);
        btnPosts=(Button)findViewById(R.id.btnPosts);
        btnAlbums=(Button)findViewById(R.id.btnAlbums);
        btnTodos=(Button)findViewById(R.id.btnTodos);
        btnToToDo=(Button)findViewById(R.id.btnToToDo);
        btnToPost=(Button)findViewById(R.id.btnToPost);
        btnUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "!!!!!1onClick:!!!!!!");
                Intent intent=new Intent(MainActivity.this, UserActivity.class);
                startActivity(intent);
            }
        });
        btnPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, PostActivity.class);
                startActivity(intent);


            }
        });
        btnAlbums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "!!!!!!!!!!onClick: ");
                Intent intent=new Intent(MainActivity.this, AlbumActivity.class);
                startActivity(intent);

            }
        });
        btnTodos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, ToDoActivity.class);
                startActivity(intent);

            }
        });

    }
}
