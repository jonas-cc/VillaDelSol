package com.example.villadelsol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PaquetesR2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paquetes_r2);
    }

    public void cita(View view) {
        Intent date= new Intent(this,AgeDate.class);
        startActivity(date);
    }
}