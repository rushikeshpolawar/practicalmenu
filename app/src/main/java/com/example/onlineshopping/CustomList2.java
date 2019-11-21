package com.example.onlineshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomList2 extends ArrayAdapter<String>
{
    Activity context;
    Integer Image[];
    String [] Name,Price;
    int pos;

    public CustomList2(Activity context, String[] Name,String[] Price, Integer[] Image) {
        super(context,R.layout.activity_custom_list,Name);
        this.context=context;
        this.Name=Name;
        this.Price=Price;
        this.Image=Image;
    }

    public View getView(int position, View view, ViewGroup parent)
    {
        pos=position;
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.activity_custom_list2,null,true);
        TextView name=(TextView)rowView.findViewById(R.id.name);
        TextView price=(TextView)rowView.findViewById(R.id.price);
        ImageView image=(ImageView)rowView.findViewById(R.id.image);
        name.setText(Name[position]);
        price.setText(Price[position]);
        image.setImageResource(Image[position]);
        return rowView;
    }

}

