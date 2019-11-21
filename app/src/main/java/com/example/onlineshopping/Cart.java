package com.example.onlineshopping;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class Cart extends AppCompatActivity {

    String [] name,price;Integer image[];
    ArrayList<String> nameList=new ArrayList<>();
    ArrayList<String> priceList=new ArrayList<>();
    ArrayList<Integer> imageList=new ArrayList<>();
    AlertDialog.Builder builder,builder2;
    Button b1;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Intent data=getIntent();
        nameList=data.getStringArrayListExtra("name");
        priceList=data.getStringArrayListExtra("price");
        imageList=data.getIntegerArrayListExtra("image");
        name=new String[nameList.size()];
        price=new String[priceList.size()];
        image=new Integer[imageList.size()];
        for(int i=0;i<nameList.size();i++)
        {
            name[i]=nameList.get(i);
            price[i]=priceList.get(i);
            image[i]=imageList.get(i);
        }
        ListView lv=(ListView)findViewById(R.id.lv);
        CustomList2 cl=new CustomList2(this,name,price,image);
        lv.setAdapter(cl);
        builder = new AlertDialog.Builder(this);
        builder2 = new AlertDialog.Builder(this);
        b1=(Button)findViewById(R.id.proceed);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int total=0;
                for(String x:price)
                {
                    total=total+Integer.parseInt(x);
                }

                builder.setMessage("Total price is "+total)
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Calendar c = Calendar.getInstance();
                                int day = c.get(Calendar.DAY_OF_MONTH)+3;
                                int month = c.get(Calendar.MONTH);
                                int year = c.get(Calendar.YEAR);
                                String date = day + "/" + (month) + "/" + year;
                                builder2.setMessage("Place will be shipped by "+date);
                                AlertDialog alert2 = builder2.create();
                                alert2.setTitle("Order Placed");
                                dialog.cancel();
                                alert2.show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();
                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Do you want to place the order ?");
                alert.show();
            }
        });
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
