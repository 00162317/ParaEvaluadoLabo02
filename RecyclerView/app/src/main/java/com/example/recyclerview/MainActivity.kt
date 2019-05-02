package com.example.recyclerview

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_adapter.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //TODO (10) Instanciamos al adapter
    lateinit var mAdapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TODO(11) Instancia para llamar el recycler creado en el XML
        val recycler: RecyclerView = findViewById(R.id.recyclerView_xml)

        recycler.layoutManager = LinearLayoutManager(this)

        //TODO(12) Esto es por que el Adapter tiene como parametro una lista de "ObjetoPersona" y por eso la lista es de ese tipo.
        val listaPersona=ArrayList<ObjetoPersona>()

        //TODO(13) El evento de click cuando haya escrito los datos
        btn_send.setOnClickListener {
            val name1 = edit_text_nombre_xml.text.toString()
            val lastName = edit_text_apellido_xml.text.toString()
            //TODO(13.1)Agregamos a la lista los valores agregados por el usuario
            listaPersona.add(ObjetoPersona(name1,lastName))
            //TODO(14) En teoria se hacae la instancia del adapter, pues se la pasamos como parametro la lista.
            //TODO(22) Ahora le pasamos como parametro la funcion creada en el comentario 21
            mAdapter = Adapter(listaPersona,{variable:ObjetoPersona->personaItemClicked(variable)})
            //TODO(15) Vaya ahora al recycler del XML le asignamos los valores de la dicha lista del comentario anterior.
            recycler.adapter=mAdapter
        }
    }
    //TODO(21) Ahora en el comentario 14 dara vergazo por que le agregamos un nuevo parametro.
    //TODO (21.1) Ahora, una funcion que se encargara del evento del click con parametro del objeto
    private fun personaItemClicked(item:ObjetoPersona){
    //TODO(21.2) Inciamos el INTENTO
        startActivity(Intent(this,ViewerPersona::class.java)
                //TODO(25) Aqui se hace la sentencia PutExtra con el fin de setear
            .putExtra("Nombre",text_view_adapter_nombre.text.toString())
            .putExtra("Apellido",text_view_adapter_apellido.text.toString()))
    }
}
