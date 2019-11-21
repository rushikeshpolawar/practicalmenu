package com.example.onlineshopping;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class CustomList extends ArrayAdapter<String>
{
    Activity context;
    Integer Image[];
    String [] Name,Price;

    ArrayList<String> nameList=new ArrayList<>();
    ArrayList<String> priceList=new ArrayList<>();
    ArrayList<Integer> imageList=new ArrayList<>();

    public CustomList(Activity context, String[] Name,String[] Price, Integer[] Image) {
        super(context,R.layout.activity_custom_list,Name);
        this.context=context;
        this.Name=Name;
        this.Price=Price;
        this.Image=Image;
    }

    public View getView(final int position, View view, ViewGroup parent)
    {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.activity_custom_list,null,true);
        TextView name=(TextView)rowView.findViewById(R.id.name);
        TextView price=(TextView)rowView.findViewById(R.id.price);
        ImageView image=(ImageView)rowView.findViewById(R.id.image);
        name.setText(Name[position]);
        price.setText(Price[position]);
        image.setImageResource(Image[position]);
        final Button b =(Button) rowView.findViewById(R.id.cb);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity ob=new MainActivity();
                if(!imageList.contains(Image[position]))
                {
                    b.setText("Added");
                    nameList.add(Name[position]);
                    priceList.add(Price[position]);
                    imageList.add(Image[position]);
                }
                else
                    Toast.makeText(getContext(),"Product is already added to cart", Toast.LENGTH_SHORT).show();
            }
        });
        return rowView;
    }
    ArrayList<String> getName()
    {
        return nameList;
    }
    ArrayList<String> getPrice()
    {
        return priceList;
    }
    ArrayList<Integer> getImage()
    {
        return imageList;
    }

}
