package net.parkboy.parkboy.util.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.recycler_data.view.*
import net.parkboy.parkboy.R

class Adapter(var context: Context, var newsList: ArrayList<String>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.recycler_data, parent, false))
    }

    override fun getItemCount(): Int = newsList.size

    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {
        holder.bindView()
        holder.itemView.setOnClickListener { }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView() {
            Glide.with(context).load(newsList[adapterPosition]).into(itemView.newsHead)
        }
    }
}