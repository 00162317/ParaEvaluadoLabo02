package com.example.recyclerview.Fragmento

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recyclerview.Modelo.ObjetoPersona
import com.example.recyclerview.R
import kotlinx.android.synthetic.main.fragment_fragment_first.*
import kotlinx.android.synthetic.main.fragment_fragment_second.*
import kotlinx.android.synthetic.main.fragment_fragment_second.view.*

class fragment_second : Fragment() {

    companion object {
        fun newInstance(nombreVar:String, lastName:String):fragment_second{
            var personaFragment = fragment_second()
            val args = Bundle()
            args.putString("Nombre",nombreVar)
            args.putString("Apellido",lastName)
            personaFragment.arguments=args
            return personaFragment
        }
    }
    lateinit var viewGlobal : View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_fragment_second, container, false)

        viewGlobal=view

        /*val name = arguments!!.getString("Nombre")
        val apellido= arguments!!.getString("Apellido")
        val person= arguments!!.getString("Persona")*/
        return view
    }
}
