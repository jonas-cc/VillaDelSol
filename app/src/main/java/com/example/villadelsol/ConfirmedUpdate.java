package com.example.villadelsol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ConfirmedUpdate extends AppCompatActivity {
    EditText nombrejson, correojson, telefonojson;
    EditText txtEvento,txtfecha,txtSalon,txtInvitados;
    Spinner tipo, room, inv;
    String id="", url="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmed_update);
        nombrejson=findViewById(R.id.editTextTextPersonName3);
        correojson=findViewById(R.id.editTextTextEmailAddress3);
        telefonojson=findViewById(R.id.editTextPhone2);
        txtEvento=findViewById(R.id.editTextTextPersonName5);
        txtfecha=findViewById(R.id.editTextDate2);
        txtSalon=findViewById(R.id.editTextTextPersonName6);
        txtInvitados=findViewById(R.id.editTextTextPersonName7);
        tipo=findViewById(R.id.spinner4);
        room=findViewById(R.id.spinner5);
        inv=findViewById(R.id.spinner6);

        Bundle parametros = this.getIntent().getExtras();
        if(parametros!=null){
            id=parametros.getString("id");
            String nombre=parametros.getString("nombre");
            String correo=parametros.getString("correo");
            String telefono=parametros.getString("telefono");
            String tipoEvento=parametros.getString("tEvento");
            String fecha=parametros.getString("fecha");
            String salon=parametros.getString("salon");
            String invitados=parametros.getString("invitados");

            if (tipoEvento.equals("Infantil")){
            }

            nombrejson.setText(nombre);
            correojson.setText(correo);
            telefonojson.setText(telefono);
            txtEvento.setText(tipoEvento);
            txtfecha.setText(fecha);
            txtSalon.setText(salon);
            txtInvitados.setText(invitados);
            System.out.println("Invitados: "+invitados);

        }
    }
    public void actualizar(View v){
        url="https://node-villa-del-sol.herokuapp.com/api/actualizarCita/"+id;
        System.out.println(url);
        webServices();
    }

    private void webServices() {
        RequestQueue servicioConsulta= Volley.newRequestQueue(this);
        StringRequest respuestaConsulta= new StringRequest(Request.Method.PUT,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        JSONObject json= null;
                        //JSONObject cita = jParser.get

                        /*nombrejson.setText("");
                        correojson.setText("");
                        telefonojson.setText("");
                        txtEvento.setText("");
                        txtfecha.setText("");
                        txtSalon.setText("");
                        txtInvitados.setText("");*/

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
                                nombrejson.append(cita.getString("nombre"));
                                correojson.append(cita.getString("correo"));
                                telefonojson.append(cita.getString("telefono"));
                                txtEvento.append(cita.getString("tipoEvento"));
                                txtfecha.append(cita.getString("fecha"));
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
            params.put("nombre", nombrejson.getText().toString());
            params.put("correo", correojson.getText().toString());
            params.put("telefono", telefonojson.getText().toString());
            params.put("tipoEvento", tipo.getSelectedItem().toString());
            params.put("salon", room.getSelectedItem().toString());
            params.put("fecha", txtfecha.getText().toString());
            params.put("numInvitados", inv.getSelectedItem().toString());
            return params;
        }        };
        servicioConsulta.add(respuestaConsulta);
    }


}