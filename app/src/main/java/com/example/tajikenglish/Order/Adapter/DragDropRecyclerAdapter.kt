package com.example.tajikenglish.Order.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.tajikenglish.Order.Model.OrderModel
import com.example.tajikenglish.R
import kotlinx.android.synthetic.main.layout_recyclerview_item.view.*
import java.io.InputStream
import java.util.*


class DragDropRecyclerAdapter(
    val context: Context,
    private val startDragListener: OnStartDragListener,
) :
    RecyclerView.Adapter<DragDropRecyclerAdapter.ItemViewHolder>(),
    ItemMoveCallbackListener.Listener {


    private var orderArray = emptyList<OrderModel>().toMutableList()

    fun setUsers(newUsers: List<OrderModel>) {
        orderArray.clear()
        orderArray.addAll(newUsers)
    }

    override fun getItemCount(): Int {
        return orderArray.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_recyclerview_item, parent, false)
        return ItemViewHolder(itemView)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val orderArrayPosition = orderArray[position]
        holder.bind(orderArrayPosition, context)

        holder.itemView.imageView.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                this.startDragListener.onStartDrag(holder)
            }

            return@setOnTouchListener true
        }

        holder.itemView.tag = position
    }


    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewAlphabet: ImageView = itemView.findViewById(R.id.imageViewAlphabet)

        fun bind(data: OrderModel, context: Context) {
            try {
                val inputStream: InputStream = context.getAssets().open(data.image)
                val image = Drawable.createFromStream(inputStream, null)
                imageViewAlphabet.setImageDrawable(image)
                imageViewAlphabet.tag = data
            }catch (ex:Exception){
                ex.message?.let {
                    Log.e(DragDropRecyclerAdapter::class.java.simpleName,it)
                }
            }
        }
    }

    override fun onRowMoved(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(orderArray, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(orderArray, i, i - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onRowSelected(itemViewHolder: ItemViewHolder) {

    }

    override fun onRowClear(itemViewHolder: ItemViewHolder) {

    }

    fun onClickForButton(): Boolean {
        var i = 0
        var a = true
        while (i < orderArray.size) {

            if (orderArray[i].id != i + 1) {
                return false
            } else {
                a = true
            }
            i++
        }
        return a
    }

}