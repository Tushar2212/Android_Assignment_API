package com.example.siddhant.myappfinal.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.siddhant.myappfinal.R;
import com.example.siddhant.myappfinal.activites.PhotosActivity;
import com.example.siddhant.myappfinal.models.Album;

import java.util.ArrayList;

/**
 * Created by siddhant on 03-07-2017.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {
    Context context;
    ArrayList<Album> listAlbum;
    public static final String TAG=" aa";

    public AlbumAdapter(Context context, ArrayList<Album> listAlbum) {
        Log.d(TAG, "!!!!!!!!!!!AlbumAdapterConstructor: ");
        this.context = context;
        this.listAlbum = listAlbum;
    }

    public void updateAlbums (ArrayList<Album> listAlbum) {
        this.listAlbum=listAlbum;
        notifyDataSetChanged();
    }
    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "!!!!!!!!!!!!!!onCreateViewHolderAlbum: ");
        LayoutInflater li= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=li.inflate(R.layout.album_list,parent,false);
        return new AlbumViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AlbumViewHolder holder, int position) {
        Log.d(TAG, "!!!!!!!!!!!!!!!onBindViewHolderAlbum: ");
        final Album thisAlbum=listAlbum.get(position);
        holder.tvAlbumTitle.setText(thisAlbum.getTitle());
        holder.thisView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "!!!!!!!!!!!!onClickAlbum: ");
                Intent i= new Intent(context, PhotosActivity.class);
                i.putExtra("albumId",thisAlbum.getUserId());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listAlbum.size();
    }

    public class AlbumViewHolder extends RecyclerView.ViewHolder{
        TextView tvAlbumTitle;
        View thisView;
        public AlbumViewHolder(View itemView) {
            super(itemView);
            Log.d(TAG, "!!!!!!!!!!AlbumViewHolderConstructor: ");
            thisView=itemView;
            tvAlbumTitle=(TextView)itemView.findViewById(R.id.tvAlbumTitle);

        }
    }
}
