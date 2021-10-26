package com.example.tajikenglish.order

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tajikenglish.order.adapter.DragDropRecyclerAdapter
import com.example.tajikenglish.order.adapter.ItemMoveCallbackListener
import com.example.tajikenglish.order.adapter.OnStartDragListener
import com.example.tajikenglish.modules.models.OrderModel
import com.example.tajikenglish.order.view_model.OrderViewModel
import com.example.tajikenglish.R

class OrderActivity : AppCompatActivity(), OnStartDragListener {

    lateinit var adapter: DragDropRecyclerAdapter
    lateinit var touchHelper: ItemTouchHelper
    lateinit var recyclerView: RecyclerView
    lateinit var button: Button
    lateinit var reset: Button
    private lateinit var vm: OrderViewModel


    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        vm = ViewModelProvider(this).get(OrderViewModel::class.java)
        recyclerView = findViewById(R.id.recyclerView)


        button = findViewById(R.id.button)
        reset = findViewById(R.id.reset)
        reset.setOnClickListener {

            // Toast.makeText(this, "korkad", Toast.LENGTH_SHORT).show()
            adapter.notifyDataSetChanged()
            populateListItem()


        }



        adapter = DragDropRecyclerAdapter(this, this)
        populateListItem()

        val callback: ItemTouchHelper.Callback = ItemMoveCallbackListener(adapter)

        touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        button.setOnClickListener {

            if (adapter.onClickForButton()) {
                Toast.makeText(this, "Durust", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Khato", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStartDrag(viewHolder: RecyclerView.ViewHolder) {
        touchHelper.startDrag(viewHolder)
    }

    private fun populateListItem() {
        var a = (0..15).random()
        var b = (18..35).random()

        var alphabetsArray: ArrayList<OrderModel> = ArrayList()
        vm.getAlphabet().observe(this, Observer {

            fun randomArray() {
                while (a < b) {
                    alphabetsArray.add(OrderModel(it[a].id, it[a].image))
                    a++
                }
            }
            randomArray()
            adapter.setUsers(alphabetsArray)
        })

    }


}
