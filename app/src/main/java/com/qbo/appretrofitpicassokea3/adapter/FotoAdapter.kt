package com.qbo.appretrofitpicassokea3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.qbo.appretrofitpicassokea3.R
import com.qbo.appretrofitpicassokea3.model.Foto
import com.squareup.picasso.Picasso

class FotoAdapter(private val lstfoto: List<Foto>)
    : RecyclerView.Adapter<FotoAdapter.ViewHolder>()
{
    class ViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {
        val tvtitulofoto: TextView = itemView.findViewById(R.id.tvtitulofoto)
        val ivfoto: ImageView = itemView.findViewById(R.id.ivfoto)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FotoAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_foto,
                                                    parent, false))
    }
    override fun onBindViewHolder(holder: FotoAdapter.ViewHolder, position: Int) {
        val itemfoto = lstfoto[position]
        holder.tvtitulofoto.text = itemfoto.title
        Picasso.get().load(itemfoto.url).into(holder.ivfoto)
    }
    override fun getItemCount(): Int {
        return lstfoto.size
    }
}