package com.example.recyclerview.Recycler

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.recyclerview.Fragmento.fragment_second
import com.example.recyclerview.R
import kotlinx.android.synthetic.main.activity_viewer_persona.*
import kotlinx.android.synthetic.main.fragment_fragment_second.*
import kotlinx.android.synthetic.main.fragment_fragment_second.view.*

class ViewerPersona : AppCompatActivity() {
    /*TODO(16) Cuando ingresa, se va metiendo en la lista o sea recycler. Vaya ahora cuando le de click a una le de click
    * voy a querer que habra en otra actividad aparte donde muestre esa informacion en especifico*/

    lateinit var viewGlobal : View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewer_persona)




        val fragment= fragment_second.newInstance("Rob","Hernandez")
        supportFragmentManager.beginTransaction().replace(R.id.land_segundo,fragment).commit()
    }
}
