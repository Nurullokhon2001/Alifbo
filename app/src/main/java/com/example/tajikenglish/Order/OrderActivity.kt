package com.example.tajikenglish.Order

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tajikenglish.R

class OrderActivity : AppCompatActivity(), OnStartDragListener {

    lateinit var adapter: DragDropRecyclerAdapter
    lateinit var touchHelper: ItemTouchHelper
    lateinit var recyclerView: RecyclerView
    lateinit var button : Button
              var users : ArrayList<OrderModel> = ArrayList()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        recyclerView=findViewById(R.id.recyclerView)


        button = findViewById(R.id.button)



        adapter = DragDropRecyclerAdapter(this, this)
        populateListItem()

        val callback: ItemTouchHelper.Callback = ItemMoveCallbackListener(adapter)

        touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        button.setOnClickListener {
            adapter.onClickForButton()
        }
    }

    override fun onStartDrag(viewHolder: RecyclerView.ViewHolder) {
        touchHelper.startDrag(viewHolder)
    }

    private fun populateListItem() {
        users.add(OrderModel(1,R.drawable.abc))
        users.add(OrderModel(2,R.drawable.abc))
        users.add(OrderModel(3,R.drawable.abc))
        users.add(OrderModel(4,R.drawable.abc))
        users.add(OrderModel(5,R.drawable.abc))
        users.add(OrderModel(6,R.drawable.abc))
        users.add(OrderModel(7,R.drawable.abc))

        adapter.setUsers(users)
    }



}
