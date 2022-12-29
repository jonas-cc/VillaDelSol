package com.example.villadelsol.ui.citas;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.villadelsol.ConfirmedUpdate;
import com.example.villadelsol.R;
import com.example.villadelsol.databinding.FragmentCitasBinding;
import com.example.villadelsol.databinding.FragmentGalleryBinding;
import com.example.villadelsol.databinding.FragmentRoom1Binding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CitasFragment extends Fragment {

    EditText idD, idU;
    String idBorrar="";
    String url="";

    RequestQueue respuestaService;
    ArrayList<String> datos=new ArrayList<>();//listas
    ListView lista;

    private FragmentCitasBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_citas,container,false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        idD=view.findViewById(R.id.editTextTextPersonName4);
        idU=view.findViewById(R.id.editTextTextPersonName);
        Button delete=view.findViewById(R.id.button3);
        Button update=view.findViewById(R.id.button);
        delete.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                eliminar();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarID();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    public String setIDBorrar(){
        String value=idD.getText().toString();
        idBorrar=value;
        return idBorrar;
    }

    public void eliminar() {
        String value=idD.getText().toString();
        System.out.println("ID:"+value);
        if(value.equals("")){
            System.out.println("Ingresa un ID");
            Toast.makeText(getActivity(),"Ingresa un ID", Toast.LENGTH_SHORT).show();
        }else{

            url="http://192.168.56.1:3400/api/borrarCita/"+value;
            StringRequest respuesta3= new StringRequest(Request.Method.DELETE, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(getActivity(),response, Toast.LENGTH_SHORT).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getActivity(), "No existe una Cita con ese ID", Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> idEliminar= new HashMap<String,String>();
                    idEliminar.put("id",idD.getText().toString());
                    return idEliminar;
                }
            };

            respuestaService= Volley.newRequestQueue(getActivity());
            respuestaService.add(respuesta3);
        }
    }
    public void validarID(){
        String value=idU.getText().toString();
        url="https://node-villa-del-sol.herokuapp.com/api/mostrarCita/"+value;
        System.out.println(url);

        JsonObjectRequest respuestaBusqueda=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JSONObject jsonobject=null;
                String nombre="",correo="", tEvento="", fecha="", salon="", telefono="", invitados="";

                if (response!=null){
                    System.out.println("ID: "+ value);
                    try {
                        jsonobject=response.getJSONObject("cita");
                        nombre= jsonobject.getString("nombre");
                        correo= jsonobject.getString("correo");
                        telefono= jsonobject.getString("telefono");
                        tEvento= jsonobject.getString("tipoEvento");
                        fecha= jsonobject.getString("fecha");
                        salon= jsonobject.getString("salon");
                        invitados= jsonobject.getString("numInvitados");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Nombre del CLIENTE: "+nombre);
                    System.out.println(response);
                }else{
                    System.out.println("No existe un ID");
                }
                //jsonobject=response.getJSONObject();


                Toast.makeText(getActivity(),"Existe un ID",Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(),"ID: "+value+" Nombre: "+nombre,Toast.LENGTH_SHORT).show();
                Intent confirm_update =new Intent(getActivity(), ConfirmedUpdate.class);
                confirm_update.putExtra("id",value);
                confirm_update.putExtra("nombre",nombre);
                confirm_update.putExtra("correo",correo);
                confirm_update.putExtra("telefono",telefono);
                confirm_update.putExtra("tEvento", tEvento);
                confirm_update.putExtra("fecha",fecha);
                confirm_update.putExtra("salon",salon);
                confirm_update.putExtra("invitados",invitados);
                startActivity(confirm_update);




                /*JSONObject json=null;

                String datoTemp="";
                for (int i = 0; i <response.length() ; i++) {
                    try{
                        json=response.getJSONObject(i);
                        datoTemp+="ID: "+json.getString("_id");
                        datoTemp+="Nombre: "+json.getString("nombre");
                        datoTemp+="Correo: "+json.getString("correo");
                        datoTemp+="Telefono: "+json.getString("telefono");
                        datoTemp+="TipoEvento: "+json.getString("tipoEvento");
                        datoTemp+="Fecha: "+json.getString("fecha");
                        datoTemp+="Salon: "+json.getString("salon");
                        datoTemp+="No. Invitados: "+json.getString("numInvitados");
                        datos.add(datoTemp);

                        datoTemp="";
                    } catch (JSONException e) {
                        Toast.makeText(getActivity(),"Error en el formato",Toast.LENGTH_SHORT).show();
                    }
                }
                System.out.println();
                Toast.makeText(getActivity(),datoTemp,Toast.LENGTH_SHORT).show();*/

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
                //Toast.makeText(getActivity(),error.toString(),Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(),"No existe una cita con ese ID",Toast.LENGTH_SHORT).show();
            }
        });

        respuestaService= Volley.newRequestQueue(getActivity());
        respuestaService.add(respuestaBusqueda);
    }
}