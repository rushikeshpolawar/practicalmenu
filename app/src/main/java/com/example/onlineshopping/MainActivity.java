package com.example.onlineshopping;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Intent i;
    ArrayList<String> nameList=new ArrayList<>();
    ArrayList<String> priceList=new ArrayList<>();
    ArrayList<Integer> imageList=new ArrayList<>();
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_select, menu);
        return true;
    }
    private boolean MenuChoice(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menu1:
                i=new Intent(getApplicationContext(),Clothes.class);
                i.putStringArrayListExtra("name",nameList);
                i.putStringArrayListExtra("price",priceList);
                i.putIntegerArrayListExtra("image",imageList);
                startActivityForResult(i,0);
                return true;
            case R.id.menu2:
                return  true;
            case R.id.submenu1:
                i=new Intent(getApplicationContext(),Shoes.class);
                i.putStringArrayListExtra("name",nameList);
                i.putStringArrayListExtra("price",priceList);
                i.putIntegerArrayListExtra("image",imageList);
                startActivityForResult(i,0);
                return true;
            case R.id.submenu2:
                i=new Intent(getApplicationContext(),Watch.class);
                i.putStringArrayListExtra("name",nameList);
                i.putStringArrayListExtra("price",priceList);
                i.putIntegerArrayListExtra("image",imageList);
                startActivityForResult(i,0);
                return true;
            case R.id.menu3:
                i=new Intent(getApplicationContext(),Gadget.class);
                i.putStringArrayListExtra("name",nameList);
                i.putStringArrayListExtra("price",priceList);
                i.putIntegerArrayListExtra("image",imageList);
                startActivityForResult(i,0);
                return true;
            case R.id.menu4:
                i=new Intent(getApplicationContext(),Mobile.class);
                i.putStringArrayListExtra("name",nameList);
                i.putStringArrayListExtra("price",priceList);
                i.putIntegerArrayListExtra("image",imageList);
                startActivityForResult(i,0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return MenuChoice(item);
    }

    }


