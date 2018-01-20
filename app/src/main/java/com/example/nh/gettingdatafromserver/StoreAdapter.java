package com.example.nh.gettingdatafromserver;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class StoreAdapter extends ArrayAdapter<Store> {
    private ArrayList<Store>storesList;
    private Context context;
    public StoreAdapter(Context context, int resource,ArrayList<Store>storesList) {
        super(context, resource);
        this.context=context;
        this.storesList=storesList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.store_row,parent,false);

        TextView title= (TextView) view.findViewById(R.id.store_title);
        ImageView logo= (ImageView) view.findViewById(R.id.store_logo);

        title.setText(storesList.get(position).getStoreName());

        return view;
    }

    @Override
    public int getCount() {
        return storesList.size();
    }
}
