package com.example.talent_manager_client.File_Listview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.talent_manager_client.R;

import java.util.ArrayList;
import java.util.List;

public class MyListAdapter extends BaseAdapter {

    private List<File> list = new ArrayList<>();
    private Context context;
    private FilterListener listener = null;// 接口对象

    public MyListAdapter(List<File> list, Context context, FilterListener filterListener) {


        this.list = list;
        this.context = context;
        this.listener = filterListener;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        Log.e("cbwcbwjec",String.valueOf(list.size()));
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }





    public View getView(int position, View convertView, ViewGroup parent) {

        Log.e("dcbwbcwj","调用getview");
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.fragment_file_cell, null);
            holder = new ViewHolder();


            holder.tvJob = convertView.findViewById(R.id.file_job);
            holder.tvDate = convertView.findViewById(R.id.file_date);
            holder.tvCevaluate = convertView.findViewById(R.id.file_evaluate);


            holder.imageView = convertView.findViewById(R.id.file_image);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }





        holder = (ViewHolder) convertView.getTag();
        holder.tvJob.setText(list.get(position).getJob());
        holder.tvDate.setText(list.get(position).getDate());
        holder.tvCevaluate.setText(list.get(position).getCevaluate());

        byte[] in = list.get(position).getBitmap();
        Bitmap bmp = BitmapFactory.decodeByteArray(in, 0, in.length );
        holder.imageView.setImageBitmap(bmp);
        return convertView;
    }

    class ViewHolder {
        private ImageView imageView;
        private TextView tvJob,tvDate,tvCevaluate;
    }
}