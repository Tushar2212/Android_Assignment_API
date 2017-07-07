package com.example.siddhant.myappfinal.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.siddhant.myappfinal.R;
import com.example.siddhant.myappfinal.activites.PostActivity;
import com.example.siddhant.myappfinal.activites.ToDoActivity;
import com.example.siddhant.myappfinal.activites.UserActivity;
import com.example.siddhant.myappfinal.models.Post;
import com.example.siddhant.myappfinal.models.User;

import java.util.ArrayList;



/**
 * Created by siddhant on 03-07-2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    Context context;
    ArrayList<User> userItemList;
    public static final String TAG=" ";
    Button btnToPost;
    public UserAdapter(Context context, ArrayList<User> userItemList) {
        this.context = context;
        this.userItemList = userItemList;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        LayoutInflater li=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=li.inflate(R.layout.user_list,parent,false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
    final User thisUser=userItemList.get(position);
       // holder.userId.setText(thisUser.getId());
        holder.uName.setText(thisUser.getName());
        holder.userName.setText(thisUser.getUsername());
        holder.btnToPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, PostActivity.class);
                i.putExtra("userId",thisUser.getId());
                context.startActivity(i);
            }
        });
        holder.btnToToDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(context, ToDoActivity.class);
                i.putExtra("userId",thisUser.getId());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: ");
        return userItemList.size();
    }
    public void updateUsers (ArrayList<User> userItemList) {
        Log.d(TAG, "updateUsers: ");
        this.userItemList=userItemList;
        notifyDataSetChanged();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
    TextView userName,uName,userId;
    Button btnToPost,btnToToDo;
        public UserViewHolder(View itemView) {
            super(itemView);
            Log.d(TAG, "UserViewHolder: ");
            userName=(TextView)itemView.findViewById(R.id.tvUserName);
            uName=(TextView)itemView.findViewById(R.id.tvName);
           // userId=(TextView)itemView.findViewById(R.id.tvUserId);
            btnToPost=(Button)itemView.findViewById(R.id.btnToPost);
            btnToToDo=(Button)itemView.findViewById(R.id.btnToToDo);
        }
    }
}
