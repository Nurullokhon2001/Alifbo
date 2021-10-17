package com.example.tajikenglish.Order

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tajikenglish.Alphabet.repository.model.AlphabetsModel
import com.example.tajikenglish.Order.Adapter.DragDropRecyclerAdapter
import com.example.tajikenglish.Order.Adapter.ItemMoveCallbackListener
import com.example.tajikenglish.Order.Adapter.OnStartDragListener
import com.example.tajikenglish.Order.Model.OrderModel
import com.example.tajikenglish.R

class OrderActivity : AppCompatActivity(), OnStartDragListener {

    lateinit var adapter: DragDropRecyclerAdapter
    lateinit var touchHelper: ItemTouchHelper
    lateinit var recyclerView: RecyclerView
    lateinit var button: Button
    lateinit var reset: Button
    var number: Int = 0


    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        recyclerView = findViewById(R.id.recyclerView)


        button = findViewById(R.id.button)
        reset = findViewById(R.id.reset)
        reset.setOnClickListener {
            number = (0..3).random()
            // Toast.makeText(this, "korkad", Toast.LENGTH_SHORT).show()
            adapter.notifyDataSetChanged()
            populateListItem()

        }



        adapter = DragDropRecyclerAdapter(this,this)
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
        when (number) {
            0 -> {
                val users: ArrayList<OrderModel> = ArrayList()
                users.add(OrderModel(0, "rasmho/anor.jpg"))
                users.add(OrderModel(0, "rasmho/anor.jpg"))
                users.add(OrderModel(0, "rasmho/anor.jpg"))
                users.add(OrderModel(0, "rasmho/anor.jpg"))
                users.add(OrderModel(0, "rasmho/anor.jpg"))

                adapter.setUsers(users)
            }
            1 -> {
                val users: ArrayList<OrderModel> = ArrayList()

                users.add(OrderModel(0, "rasmho/anor.jpg"))
                users.add(OrderModel(0, "rasmho/anor.jpg"))
                users.add(OrderModel(0, "rasmho/anor.jpg"))
                users.add(OrderModel(0, "rasmho/anor.jpg"))
                users.add(OrderModel(0, "rasmho/anor.jpg"))
                adapter.setUsers(users)
            }
            2 -> {
                val users: ArrayList<OrderModel> = ArrayList()

                users.add(OrderModel(0, "rasmho/anor.jpg"))
                users.add(OrderModel(0, "rasmho/anor.jpg"))
                users.add(OrderModel(0, "rasmho/anor.jpg"))
                users.add(OrderModel(0, "rasmho/anor.jpg"))
                users.add(OrderModel(0, "rasmho/anor.jpg"))

                adapter.setUsers(users)
            }
            3 -> {
                val users: ArrayList<OrderModel> = ArrayList()

                users.add(OrderModel(0, "rasmho/anor.jpg"))
                users.add(OrderModel(0, "rasmho/anor.jpg"))
                users.add(OrderModel(0, "rasmho/anor.jpg"))
                users.add(OrderModel(0, "rasmho/anor.jpg"))
                users.add(OrderModel(0, "rasmho/anor.jpg"))

                adapter.setUsers(users)
            }
        }
    }


}
