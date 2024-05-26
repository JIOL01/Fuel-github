package com.appnica.api_libre

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HouseAdapter (private val houses: List<Houses>):
    RecyclerView.Adapter<HouseAdapter.HouseViewHolder>()
{
    class HouseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        private val txtSlug = itemView.findViewById<TextView>(R.id.txtSlug)
        private val txtName = itemView.findViewById<TextView>(R.id.txtName)
        private val txtName2 = itemView.findViewById<TextView>(R.id.txtName2)
        private val txtSlug2 = itemView.findViewById<TextView>(R.id.txtSlug2)

        fun bind(houses: Houses){

            txtSlug.text = houses.slug
            txtName.text = houses.name
            txtName2.text = houses.members.joinToString { it.name }
            txtSlug2.text = houses.members.joinToString { it.slug }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HouseViewHolder{

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_house,parent,false)
        return HouseViewHolder(view)
    }

    override fun getItemCount(): Int {
        return houses.size
    }

    override fun onBindViewHolder(holder: HouseViewHolder, position: Int) {
        val houses =houses[position]
        holder.bind(houses)
    }
}