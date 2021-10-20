package com.example.tajikenglish.MainMenu.adaptors

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tajikenglish.R
import com.example.tajikenglish.MainMenu.Model.MainItemData
import kotlin.collections.ArrayList


class EngTopicAdapter(private var context:Context, var dataSet: ArrayList<MainItemData>,
                      private val onClickListener: View.OnClickListener) : RecyclerView.Adapter<EngTopicAdapter.MyViewHolder>()  {


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.title)
        var icon: ImageView = view.findViewById(R.id.iconImage)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.dictionary_item, parent, false)
        return MyViewHolder(view)    }

    override fun onBindViewHolder(holder: EngTopicAdapter.MyViewHolder, position: Int) {
        val data: MainItemData = dataSet.get(position)
        //   holder.itemView.startAnimation(animation)
        holder.title.text = data.title
        holder.icon.setImageResource(data.icon)
       holder.title.setTextColor(context.resources.getColor(data.color))
        holder.title.tag = position
//        holder.topicname.setOnClickListener(onClickListener)
        holder.itemView.setOnClickListener(onClickListener)
        holder.itemView.setTag(data.code)


//
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }






}




