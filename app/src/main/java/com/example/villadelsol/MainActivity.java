package com.example.villadelsol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void logobienvenida(View view){
        Intent intent_inicio = new Intent(this,ActividadInicio.class);
        startActivity(intent_inicio);
    }
}