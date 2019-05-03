package com.example.recyclerview

import android.content.Intent
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.recyclerview.Fragmento.fragment_first
import com.example.recyclerview.Fragmento.fragment_second
import com.example.recyclerview.Modelo.ObjetoPersona
import com.example.recyclerview.Recycler.Adapter
import com.example.recyclerview.Recycler.ViewerPersona
import kotlinx.android.synthetic.main.activity_adapter.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), fragment_first.personClickListener {
    override fun personaPortrait(person: ObjetoPersona) {
        //TODO(21.2) Inciamos el INTENTO
        startActivity(Intent(this, ViewerPersona::class.java)
            //TODO(25) Aqui se hace la sentencia PutExtra con el fin de setear
            .putExtra("Nombre",text_view_adapter_nombre.text.toString())
            .putExtra("Apellido",text_view_adapter_apellido.text.toString()))
    }

    override fun landscape(person: ObjetoPersona) {
        var fragmento=fragment_second.newInstance("Rob","Hern")
        supportFragmentManager.beginTransaction().replace(R.id.land_segundo,fragmento).commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(resources.configuration.orientation==Configuration.ORIENTATION_PORTRAIT){
            supportFragmentManager.beginTransaction().replace(
                R.id.land_primero,
                fragment_first()
            ).commit()
        }else{
            supportFragmentManager.beginTransaction().replace(
                R.id.land_segundo,
                fragment_second()
            ).commit()
        }
    }

}
