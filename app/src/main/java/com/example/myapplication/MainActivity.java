package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txt_result=findViewById(R.id.txt_showResult);
        Button btn_link=findViewById(R.id.btn_showlink);

        ImageView img_product=findViewById(R.id.img_prdImage);

        Glide.with(getApplicationContext()).load("https://m.media-amazon.com/images/I/41-ZuAdIKoL.jpg").into(img_product);
        Uri uri=getIntent().getData();

        if(uri!=null)
        txt_result.setText(Uri.parse(String.valueOf(uri)).getQueryParameter("productName").toString());

        btn_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {

                    Intent shareintent = new Intent();
                    shareintent.setAction(Intent.ACTION_SEND);
                    shareintent.setType("text/*");
                    shareintent.putExtra(Intent.EXTRA_TEXT, "https://www.mahendra.com/?productName=BlueShirt");
                    //shareintent.setPackage("com.whatsapp");
                    startActivity(Intent.createChooser(shareintent, "share via"));
                    // is installed or not
                    if (shareintent
                            .resolveActivity(
                                    getPackageManager())
                            == null) {
                        Toast.makeText(getApplicationContext(), "No Whatsapp Detected", Toast.LENGTH_LONG).show();
                        return;
                    }


                }
                catch(Exception e)
                {
                    Toast.makeText(getApplicationContext(),e.toString(), LENGTH_SHORT).show();
                }
            }

        });





    }
}