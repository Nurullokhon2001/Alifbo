package com.example.tajikenglish.Order.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.tajikenglish.Order.Model.OrderModel
import com.example.tajikenglish.R
import kotlinx.android.synthetic.main.layout_recyclerview_item.view.*
import java.util.*


class DragDropRecyclerAdapter(private val startDragListener: OnStartDragListener) :
    RecyclerView.Adapter<DragDropRecyclerAdapter.ItemViewHolder>(),
    ItemMoveCallbackListener.Listener {


    private var users = emptyList<OrderModel>().toMutableList()

    fun setUsers(newUsers: List<OrderModel>) {
        users.clear()
        users.addAll(newUsers)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val user = users[position]
        val pos = position
        holder.bind(user)

        holder.itemView.imageView.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                this.startDragListener.onStartDrag(holder)
            }

            return@setOnTouchListener true
        }

        holder.itemView.tag = pos
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_recyclerview_item, parent, false)
        return ItemViewHolder(itemView)
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(text: OrderModel) {


            itemView.textView.setImageResource(text.Image)
            itemView.tag

        }
    }

    override fun onRowMoved(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(users, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(users, i, i - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onRowSelected(itemViewHolder: ItemViewHolder) {

    }

    override fun onRowClear(itemViewHolder: ItemViewHolder) {

    }

//    fun onClickForButton() {
//        var i = 0
//        while (i < users.size){
//
//            if (users[i].id != i + 1) {
//                Toast.makeText(context, "Khato", Toast.LENGTH_SHORT).show()
//            }
//            else {
//                Toast.makeText(context, "Durust", Toast.LENGTH_SHORT).show()
//            }
//            i++
//
//        }
//
//    }


    fun onClickForButton(): Boolean {
        var i = 0
        var a = true
        while (i < users.size) {

            if (users[i].id != i + 1) {
                return false
            } else {
                a = true
            }
            i++
        }
        return a
    }


}