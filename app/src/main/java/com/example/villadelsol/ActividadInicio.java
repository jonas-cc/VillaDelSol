package com.example.villadelsol;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ActividadInicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_inicio);
        getSupportActionBar().show();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_inicio,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.inicio:
                //inicio();
                break;
            case R.id.salonuno:
                //inicio();
                break;
            case R.id.salondos:
                //inicio();
                break;
            case R.id.paquete:
                //inicio();
                break;
            case R.id.contacto:
                //inicio();
                break;
            case android.R.id.home:
                salir();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
    private void salir(){
       finish();
    }
}