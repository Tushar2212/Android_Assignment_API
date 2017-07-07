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
import com.example.siddhant.myappfinal.activites.PostActivity;
import com.example.siddhant.myappfinal.models.Comments;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by siddhant on 05-07-2017.
 */

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder> {
    Context context;
    ArrayList<Comments> listComments;

    @Override
    public CommentsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=li.inflate(R.layout.comments_list,parent,false);
        return new CommentsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CommentsViewHolder holder, int position) {
        Comments thisComment=listComments.get(position);

        holder.commentsName.setText(thisComment.getName());
        holder.commentsEMail.setText(thisComment.getEmail());
        holder.commentsBody.setText(thisComment.getBody());
    }



    @Override
    public int getItemCount() {
        return listComments.size();
    }

    public CommentsAdapter(Context context, ArrayList<Comments> listComments) {
        this.context = context;
        this.listComments = listComments;
    }

    public class CommentsViewHolder extends RecyclerView.ViewHolder{
               TextView commentsName,commentsEMail,commentsBody;
    public CommentsViewHolder(View itemView) {
        super(itemView);

        commentsName=(TextView)itemView.findViewById(R.id.commentsName);
        commentsEMail= (TextView)itemView.findViewById(R.id.commentsEMail);
        commentsBody=(TextView)itemView.findViewById(R.id.commentsBody);

    }
}
}
