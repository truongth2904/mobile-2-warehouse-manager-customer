package com.example.use.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.use.R;
import com.example.use.object.Cart;
import com.example.use.object.XemDonHang;

import java.util.ArrayList;

public class CustomAdapterXemDonHang extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<XemDonHang> data;

    public CustomAdapterXemDonHang(@NonNull Context context, int resource, ArrayList<XemDonHang> data) {
        super(context, resource, data);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }
    @Override
    public int getCount() {
        return data.size();
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, null);

            viewHolder = new ViewHolder();
            viewHolder.giaTien = convertView.findViewById(R.id.tvPrice);
            viewHolder.ten = convertView.findViewById(R.id.tvName);
            viewHolder.date = convertView.findViewById(R.id.tvDate);
            viewHolder.soLuong = convertView.findViewById(R.id.tvSoLuong);
            convertView.setTag(viewHolder);


        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        XemDonHang xemDonHang = data.get(position);
        viewHolder.giaTien.setText(xemDonHang.getGia() + "VNĐ");
        viewHolder.ten.setText(xemDonHang.getTen());
        viewHolder.soLuong.setText(xemDonHang.getSoLuong());
        viewHolder.date.setText(xemDonHang.getDate());
        return convertView;
    }

    private static class ViewHolder {
        TextView giaTien;
        TextView ten;
        TextView date;
        TextView soLuong;
    }
}
