package com.example.siddhant.myappfinal.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.siddhant.myappfinal.R;
import com.example.siddhant.myappfinal.models.Photos;
import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.ArrayList;

/**
 * Created by siddhant on 05-07-2017.
 */

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder> {
    Context context;
    ArrayList<Photos> listPhotos;
    public static final String TAG="PhAdAap";

    URL url;
    URL uri;
    @Override
    public PhotosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "!!!!!!!!!!!!onCreateViewHolder: ");
        LayoutInflater li=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=li.inflate(R.layout.photos_list,parent,false);
        return new PhotosViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PhotosViewHolder holder, int position) {
        Log.d(TAG, "!!!!!!!!!!!!!!!!!!!onBindViewHolder: ");
        Photos thisPhoto= listPhotos.get(position);

        holder.photoTitle.setText(thisPhoto.getTitle());

        Picasso.with(context).load(String.valueOf(thisPhoto.getThumbnailUrl())).into(holder.img);


    }

    @Override
    public int getItemCount() {
        return listPhotos.size();
    }

    public PhotosAdapter(Context context, ArrayList<Photos> listPhotos) {
        this.context = context;
        this.listPhotos = listPhotos;
    }
    public class PhotosViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView photoTitle;
        View thisView;
        public PhotosViewHolder(View itemView) {
            super(itemView);
            thisView=itemView;
           img=(ImageView)itemView.findViewById(R.id.imageView);
            photoTitle=(TextView)itemView.findViewById(R.id.tvPhotoTitle);
        }
    }
}
