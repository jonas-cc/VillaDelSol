package com.example.villadelsol;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.villadelsol.ui.home.HomeFragment;
import com.example.villadelsol.ui.slideshow.SlideshowFragment;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class AgeDate extends AppCompatActivity {
    String url="";
    RequestQueue respuestaService;


    ImageButton imgbutton;
    EditText etDate;
    DatePickerDialog.OnDateSetListener setListener;

    EditText nombre, correo,telefono,tEvento,fecha,salon,numInv;
    Spinner tipo, room, inv;
    EditText tipo1;
    String salon1="1";
    EditText txtEvento, txtSalon, txtInvitados;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_date);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        relacionarVistas();

        imgbutton=findViewById(R.id.imageButton);
        etDate=findViewById(R.id.editTextDate);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        //
        nombre=findViewById((R.id.editTextTextPersonName2));

        /*imgbutton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        AgeDate.this, android.R.style.Theme_Holo_Dialog_MinWidth,
                        setListener,year,month,day
                );
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    month= month+1;
                    String date= day+"/"+month+"/"+year;
                    etDate.setText(date);
            }
        };*/

        imgbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        AgeDate.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month=month+1;
                        String date = day+"/"+month+"/"+year;
                        etDate.setText(date);
                    }
                }, year,month,day);
                datePickerDialog.show();

            }
        });


    }
    public void relacionarVistas(){

        nombre=(EditText)findViewById(R.id.editTextTextPersonName2);
        correo=(EditText)findViewById(R.id.editTextTextEmailAddress);
        telefono=(EditText) findViewById(R.id.editTextPhone);
        tipo=(Spinner) findViewById(R.id.spinner);
        fecha=(EditText) findViewById(R.id.editTextDate);
        room=(Spinner) findViewById((R.id.spinner2));
        inv=(Spinner) findViewById(R.id.spinner3);
        txtEvento=(EditText) findViewById(R.id.txtTEvento);
        txtInvitados=(EditText) findViewById(R.id.txtInvitados);
        txtSalon=(EditText) findViewById(R.id.txtSalon);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
               /* Intent i = new Intent(this,SlideshowFragment.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);*/
                finish();


                break;
           // showSlideFragment();
        }
        return super.onOptionsItemSelected(item);
    }
    private void showSlideFragment(){
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.nav_host_fragment_content_menu,new HomeFragment());
        transaction.commit();

    }

    public void limpiar(){

    }
    public void insercion(View v){
        RequestQueue servicioJson= Volley.newRequestQueue(this);
        url="http://192.168.139.129:3400/api/registrarCita";

        webServices();
    }

    private void webServices() {
        RequestQueue servicioConsulta= Volley.newRequestQueue(this);
        StringRequest respuestaConsulta= new StringRequest(Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        JSONObject json= null;
                        //JSONObject cita = jParser.get

                        nombre.setText("");
                        correo.setText("");
                        telefono.setText("");
                        txtEvento.setText("");
                        fecha.setText("");
                        txtSalon.setText("");
                        txtInvitados.setText("");

                        txtSalon.setText(room.getSelectedItem().toString());
                        txtInvitados.setText(inv.getSelectedItem().toString());
                        txtEvento.setText(tipo.getSelectedItem().toString());
                        try {
                            json= new JSONObject(response);
                            JSONArray r = json.getJSONArray("cita");
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length() ; i++) {
                                JSONObject objeto = r.getJSONObject(i);
                                JSONObject cita = jsonArray.getJSONObject(i);
                                //t5.append(json.getString("_id"));
                                nombre.append(cita.getString("nombre"));
                                correo.append(cita.getString("correo"));
                                telefono.append(cita.getString("telefono"));
                                txtEvento.append(cita.getString("tipoEvento"));
                                fecha.append(cita.getString("fecha"));
                                txtSalon.append(cita.getString("salon"));
                                txtInvitados.append(cita.getString("numInvitados"));
                            }
                        } catch (JSONException e) {
                            Toast.makeText(getApplicationContext(),
                                    "ERROR JSON",
                                    Toast.LENGTH_SHORT).show();
                            System.out.println(e);
                        }
                        Toast.makeText(getApplicationContext(),
                                response.toString(),
                                Toast.LENGTH_SHORT).show();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),
                        "ERROR RED",
                        Toast.LENGTH_SHORT).show();
                System.out.println(error);
            }
        }){   @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            Map<String, String> params = new HashMap<>();
            params.put("nombre", nombre.getText().toString());
            params.put("correo", correo.getText().toString());
            params.put("telefono", telefono.getText().toString());
            params.put("tipoEvento", tipo.getSelectedItem().toString());
            params.put("salon", room.getSelectedItem().toString());
            params.put("fecha", fecha.getText().toString());
            params.put("numInvitados", inv.getSelectedItem().toString());
            return params;
        }        };
        servicioConsulta.add(respuestaConsulta);
    }

}


