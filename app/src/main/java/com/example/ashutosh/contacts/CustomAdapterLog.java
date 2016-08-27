package com.example.ashutosh.contacts;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by ashutosh on 19/7/16.
 */
public class CustomAdapterLog extends RecyclerView.Adapter<CustomAdapterLog.MyViewHolder> {

    private Context context;
    ArrayList<SingleLog> logs;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView name, number, time, type, duration;
        public CircularImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.singlelogName);
            number = (TextView) itemView.findViewById(R.id.singlelogNumber);
            time = (TextView) itemView.findViewById(R.id.singleLogTime);
            type = (TextView) itemView.findViewById(R.id.singleLogType);
            duration = (TextView) itemView.findViewById(R.id.SingleLogDuration);

            image = (CircularImageView)itemView.findViewById(R.id.singleLogIV);


        }
    }

    public CustomAdapterLog(ArrayList<SingleLog> logs, Context context) {
        this.context = context;
        this.logs = logs;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_log,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        SingleLog log =  logs.get(position);

        InputStream is = (InputStream) context.getResources().openRawResource(+ R.drawable.anonymous);
        Bitmap mBmp = BitmapFactory.decodeStream(is);

        holder.image.setImageBitmap(mBmp);

        holder.name.setText(log.getName());
        holder.number.setText(log.getPhone());
        holder.duration.setText(log.getDuration());
        holder.type.setText(log.getType());
        holder.time.setText(log.getDate());
    }

    @Override
    public int getItemCount() {
        return logs.size();
    }


}
