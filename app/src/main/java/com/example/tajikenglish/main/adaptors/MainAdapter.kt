package com.example.alifboitj.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tajikenglish.R
import com.example.tajikenglish.main.model.MainItemData

class MainAdapter(private val dataSet:ArrayList<MainItemData>, private val onClickListener: View.OnClickListener) : RecyclerView.Adapter<MainAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
          val view:View  = LayoutInflater.from(parent.context).inflate(R.layout.fragment_mainn, parent, false)
          return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
       return dataSet.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      val data:MainItemData =dataSet.get(position)
        holder.textView.text=data.title
        holder.itemView.tag=position
        holder.itemView.setOnClickListener(onClickListener)
    }

    class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        var textView:TextView =view.findViewById(R.id.textView)
    }
}