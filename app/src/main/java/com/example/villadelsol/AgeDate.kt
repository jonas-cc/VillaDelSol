/*package com.example.villadelsol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.*
import android.widget.EditText

class AgeDate : AppCompatActivity(){
    var txtFecha:EditText?=null
    var btnFecha:ImageButton?=null
    var dpFecha:DatePicker?=null
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_age_date)

        txtFecha=findViewById(R.id.editTextDate)
        btnFecha=findViewById(R.id.imageButton)
        dpFecha=findViewById(R.id.pick)

        txtFecha?.setText(getFechaDtePicker())
    }
    fun getFechaDtePicker():String{
        var dia = dpFecha?.dayOfMonth.toString().padStart(2,'0')
        var mes=(dpFecha!!.month+1).toString().padStart(2,'0')
        var anio=dpFecha?.year.toString().padStart(4,'0')
        return dia+"/"+mes+"/"+anio
    }

    fun showCalendar(view: View){
        dpFecha?.visibility=View.VISIBLE
    }
}*/