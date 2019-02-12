package com.example.kalya.gallery;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.RecView> {
    String root = Environment.getExternalStorageDirectory().getAbsolutePath();
    public class RecView extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView txt;
        public RecView(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.ImgIcon);
            txt = (TextView)itemView.findViewById(R.id.Text);
        }
    }
    private String[] data;
    ArrayList<Bitmap> temp = new ArrayList<Bitmap>();
    public RecAdapter( ArrayList<Bitmap> bp)
    {
        this.temp = bp;
    }

    @Override
    public RecView onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_layout,parent,false);
        return new RecView(view);
    }

    @Override
    public void onBindViewHolder(RecView holder, int position) {
        holder.imageView.setImageBitmap(temp.get(position));
    }

    @Override
    public int getItemCount() {
        return temp.size();
    }
}
