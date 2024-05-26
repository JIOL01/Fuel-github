package com.appnica.api_libre2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter(private val datas: List<Datas>):
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>()
{

    class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){


        private val txtFirstName = itemView.findViewById<TextView>(R.id.txtFirstName)
        private val txtLastName = itemView.findViewById<TextView>(R.id.txtLastName)
        private val txtFullName = itemView.findViewById<TextView>(R.id.txtFullName)
        private val txtFamily = itemView.findViewById<TextView>(R.id.txtFamily)
        private val txtImage = itemView.findViewById<TextView>(R.id.txtImage)
        private val txtImageUrl = itemView.findViewById<TextView>(R.id.txtImageUrl)

        private val photo = itemView.findViewById<ImageView>(R.id.imgMovie)


        fun bind(datas: Datas){

            txtFirstName.text = datas.firstName
            txtLastName.text = datas.lastName
            txtFullName.text = datas.fullName
            txtFamily.text = datas.family
            txtImage.text = datas.image
            txtImageUrl.text = datas.imageUrl

            Glide.with(photo.context).load(datas.imageUrl).into(photo)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder{

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie,parent,false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val datas =datas[position]
        holder.bind(datas)
    }
}