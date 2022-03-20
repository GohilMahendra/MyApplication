package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.transition.Transition;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutionException;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        String imagePath="https://www.mahendra.com/?productName=BlueShirt";
        TextView txt_result = findViewById(R.id.txt_showResult);
        Button btn_link = findViewById(R.id.btn_showlink);

        ImageView img_product = findViewById(R.id.img_prdImage);

        Glide.with(getApplicationContext()).load("https://m.media-amazon.com/images/I/41-ZuAdIKoL.jpg").diskCacheStrategy(DiskCacheStrategy.ALL).into(img_product);
        Uri uri = getIntent().getData();

        if (uri != null)
            txt_result.setText(Uri.parse(String.valueOf(uri)).getQueryParameter("productName").toString());

        btn_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                share();
            }

        });


    }


    private  void share()
    {
        try {

            Intent shareintent = new Intent();
            shareintent.setAction(Intent.ACTION_SEND);
            shareintent.setType("text/*");
            shareintent.putExtra(Intent.EXTRA_TEXT, "https://www.mahendra.com/?productName=BlueShirt");


            shareintent.putExtra(Intent.EXTRA_TITLE,"buy this");
            //for image sharing

          //  shareintent.putExtra(Intent.EXTRA_STREAM,yout_image_path);
         //   shareintent.setType("image/png");


            startActivity(Intent.createChooser(shareintent, "share via"));
            // is installed or not
            if (shareintent
                    .resolveActivity(
                            getPackageManager())
                    == null) {
                Toast.makeText(getApplicationContext(), "No Whatsapp Detected", Toast.LENGTH_LONG).show();
                return;
            }


        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.toString(), LENGTH_SHORT).show();
        }
    }



}