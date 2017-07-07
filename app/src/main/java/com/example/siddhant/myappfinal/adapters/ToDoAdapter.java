package com.example.siddhant.myappfinal.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.siddhant.myappfinal.R;
import com.example.siddhant.myappfinal.models.Post;
import com.example.siddhant.myappfinal.models.ToDo;

import java.util.ArrayList;

/**
 * Created by siddhant on 04-07-2017.
 */

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>{
    Context context;
    ArrayList<ToDo> listToDo;

    public ToDoAdapter(Context context, ArrayList<ToDo> listToDo) {
        this.context = context;
        this.listToDo = listToDo;
    }

    @Override
    public ToDoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=li.inflate(R.layout.todo_list,parent,false);
        return new ToDoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ToDoViewHolder holder, int position) {
        ToDo thisToDo=listToDo.get(position);
        holder.toDoTitle.setText(thisToDo.getTitle());
        holder.completed.setChecked(thisToDo.getCompleted());
    }
    public void updateToDo (ArrayList<ToDo> listToDo) {
        this.listToDo=listToDo;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return listToDo.size();
    }

    public class ToDoViewHolder extends RecyclerView.ViewHolder{
        TextView toDoTitle;
        CheckBox completed;
        public ToDoViewHolder(View itemView) {
            super(itemView);
            toDoTitle=(TextView)itemView.findViewById(R.id.tvToDoTitle);
            completed=(CheckBox)itemView.findViewById(R.id.cbCompleted);
        }
    }
}
