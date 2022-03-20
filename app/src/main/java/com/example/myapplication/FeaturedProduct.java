package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FeaturedProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_featured_product);

        Intent paramintent=getIntent();

        String data=paramintent.getData().toString();


        TextView txt_prdName=findViewById(R.id.txt_productName);

        txt_prdName.setText(data);
    }
}