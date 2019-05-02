package com.example.recyclerview.Recycler

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerview.R
import kotlinx.android.synthetic.main.activity_viewer_persona.*

class ViewerPersona : AppCompatActivity() {
    /*TODO(16) Cuando ingresa, se va metiendo en la lista o sea recycler. Vaya ahora cuando le de click a una le de click
    * voy a querer que habra en otra actividad aparte donde muestre esa informacion en especifico*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewer_persona)
        //TODO(23) Se necesita un intento para poder acceder a los valores del recycler
        val intento: Intent=intent

        //TODO(24) Aqui el valor del recycler se le asigna a cada textView del XML
        val nombre = intento.getStringExtra("Nombre")
        text_view_viewer_nombre.text=nombre
        //TODO(24.1) Aqui el valor del recycler se le asigna a cada textView del XML
        val apellido = intento.getStringExtra("Apellido")
        text_view_viewer_apellido.text=apellido
    }
}
