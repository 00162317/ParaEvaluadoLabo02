package com.example.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_adapter.view.*

//TODO(5) Ahora a la clase Adapter le enviaremos parametros
//TODO(5.1) Ahora tendra que heredar de recyclerView que este tendra como parametro una lista con la clase ViewHolder
//TODO(5.2) Empezara a dar un chingo de errores, solo hay que implementar y crear la clase ViewHolder que esta en la lista.
class Adapter(var items: List<ObjetoPersona>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    //TODO(1) Cree una nueva actividad EMPTY para manejar el Recycler View

    //TODO(7) En esta funcion, una ves obtenidos los datos del comentario 6, necesitaremos que
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
            = ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_adapter,parent,false))

    //TODO(8) Esta mierda asaber que hace, pero si la borras da vergazo. Pero por logica dice que retorna el temaño de la lista.
    override fun getItemCount()=items.size

    //TODO(9) Aqui una ves setados los valores en el comentario 6. Se le asigna una posicion en la lista a cada "objeto" o "cardView"
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //TODO(9.1) Mas bien aqui se setean los valores
        holder.pasarValores(items[position])
    }

    //TODO (6) El viewHolder recipe como parametro una vista que es lo que esta en el XML de "item0, item1..."
    class ViewHolder(var item: View) : RecyclerView.ViewHolder(item) {
    //TODO(6.1) Se crea una funcion con parametro Persona para poder asignarle los valores escritos del XML-1 al XML-2
        fun pasarValores(persona: ObjetoPersona)=
            with(item){
                text_view_adapter_nombre.text=persona.nombre
                text_view_adapter_apellido.text=persona.apellido

        }
    }

}