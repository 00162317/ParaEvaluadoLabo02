package com.example.recyclerview.Fragmento

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recyclerview.Modelo.ObjetoPersona
import com.example.recyclerview.R
import com.example.recyclerview.Recycler.Adapter
import com.example.recyclerview.Recycler.ViewerPersona
import kotlinx.android.synthetic.main.activity_adapter.*
import kotlinx.android.synthetic.main.fragment_fragment_first.*
import kotlinx.android.synthetic.main.fragment_fragment_first.view.*


class fragment_first : Fragment() {
    lateinit var mAdapter: Adapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    interface personClickListener{
        fun personaPortrait(person:ObjetoPersona)
        fun landscape(person: ObjetoPersona)
    }

    var listener : personClickListener?=null
    lateinit var viewGlobal : View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_fragment_first, container, false)

        viewGlobal = view

        viewManager = LinearLayoutManager(viewGlobal.context)

        val listaPersona=ArrayList<ObjetoPersona>()

        viewGlobal.btn_send.setOnClickListener {
            val name1 = edit_text_nombre_xml.text.toString()
            val lastName = edit_text_apellido_xml.text.toString()

            listaPersona.add(ObjetoPersona(name1, lastName))

            if(viewGlobal.resources.configuration.orientation==Configuration.ORIENTATION_PORTRAIT){
            mAdapter = Adapter(listaPersona,
                { variable: ObjetoPersona -> listener?.personaPortrait(variable)})
                Log.d("simon","PORT")
            }else{
                mAdapter = Adapter(listaPersona,
                    { variable: ObjetoPersona -> listener?.landscape(variable)})
                Log.d("simon","LAND")
            }
            recyclerView_xml.adapter=mAdapter
            recyclerView_xml.layoutManager=viewManager
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is personClickListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null

    }

}
