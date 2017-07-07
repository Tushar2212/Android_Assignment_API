package com.example.siddhant.myappfinal.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.siddhant.myappfinal.R;
import com.example.siddhant.myappfinal.activites.CommentsActivity;
import com.example.siddhant.myappfinal.models.Post;

import java.util.ArrayList;

/**
 * Created by siddhant on 02-07-2017.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    Context context;
    ArrayList<Post> postArrayList;


    public PostAdapter(Context context, ArrayList<Post> postArrayList) {
        this.context = context;
        this.postArrayList = postArrayList;

    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=li.inflate(R.layout.post_list,parent,false);
        return new PostViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        final Post thisPost =postArrayList.get(position);
        holder.thisView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context, CommentsActivity.class);
                i.putExtra("postId",thisPost.getUserId());
                context.startActivity(i);
            }
        });
        holder.tvPostTitle.setText(thisPost.getTitle());
        holder.tvPostBody.setText(thisPost.getBody());

    }

    @Override
    public int getItemCount() {
        return postArrayList.size();
    }



    public class PostViewHolder extends RecyclerView.ViewHolder{
        TextView tvPostTitle,tvPostBody;
        View thisView;
        public PostViewHolder(View itemView) {
            super(itemView);
            thisView=itemView;
            tvPostTitle=(TextView)itemView.findViewById(R.id.tvTitle);
            tvPostBody=(TextView)itemView.findViewById(R.id.tvBody);
        }
    }
}
