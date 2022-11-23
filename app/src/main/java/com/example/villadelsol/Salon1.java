package com.example.villadelsol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class Salon1 extends AppCompatActivity {
    ImageSlider imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon1);
        imageSlider=findViewById(R.id.SliderS1);
        ArrayList<SlideModel> imagelist=new ArrayList<>();
        imagelist.add(new SlideModel(R.drawable.s11,null));
        imagelist.add(new SlideModel(R.drawable.s12,null));
        imagelist.add(new SlideModel(R.drawable.s14,null));
        imagelist.add(new SlideModel(R.drawable.s15,null));
        imagelist.add(new SlideModel(R.drawable.s16,null));
        imagelist.add(new SlideModel(R.drawable.s17,null));
        imagelist.add(new SlideModel(R.drawable.s18,null));
        imagelist.add(new SlideModel(R.drawable.s19,null));
        imagelist.add(new SlideModel(R.drawable.s110,null));
        imagelist.add(new SlideModel(R.drawable.s111,null));
        imagelist.add(new SlideModel(R.drawable.s112,null));

        imageSlider.setImageList(imagelist);
    }
}