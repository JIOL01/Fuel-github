package com.appnica.api_pais

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PaisAdapter(private val paises: List<Paises>):
    RecyclerView.Adapter<PaisAdapter.PaisViewHolder>()
{
    class PaisViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        private val txtCommon = itemView.findViewById<TextView>(R.id.txtCommon)
        private val txtOfficeName = itemView.findViewById<TextView>(R.id.txtOfficeName)
        private val txtAltDes = itemView.findViewById<TextView>(R.id.txtAltDes)
        private val txtImageU = itemView.findViewById<TextView>(R.id.txtImageU)

        private val photo = itemView.findViewById<ImageView>(R.id.imgBandera)


        fun bind(paises: Paises){

            txtCommon.text = paises.name.common
            txtOfficeName.text = paises.name.official
            txtAltDes.text = paises.flags.alt
            txtImageU.text = paises.flags.png

            Glide.with(photo.context).load(paises.flags.png).into(photo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaisViewHolder{

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_paises,parent,false)
        return PaisViewHolder(view)
    }

    override fun getItemCount(): Int {
        return paises.size
    }

    override fun onBindViewHolder(holder: PaisViewHolder, position: Int) {
        val paises =paises[position]
        holder.bind(paises)
    }
}