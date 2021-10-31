package com.example.tajikenglish.order

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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
    lateinit var button: ImageButton
    lateinit var reset: ImageButton
    private lateinit var vm: OrderViewModel
    lateinit var gif: ImageView


    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        gif = findViewById(R.id.gifAnimation)

        vm = ViewModelProvider(this).get(OrderViewModel::class.java)
        recyclerView = findViewById(R.id.recyclerView)


        button = findViewById(R.id.button)
        reset = findViewById(R.id.reset)
        reset.setOnClickListener {

            // Toast.makeText(this, "korkad", Toast.LENGTH_SHORT).show()
            adapter.notifyDataSetChanged()
            populateListItem()


        }

        var back : ImageView = findViewById(R.id.back)

        back.setOnClickListener {
            super.onBackPressed()
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
                var a = (1..10).random()
                Toast.makeText(this, "Дуруст", Toast.LENGTH_LONG).show()
                when (a) {
                    1 -> {
                        Glide.with(this).load(R.drawable.gif).into(gif)
                        MediaPlayer.create(this, R.raw.win).start()

                        Handler().postDelayed({
                            timer()

                        }, 11000)
                    }
                    2 -> {
                        Glide.with(this).load(R.drawable.gif1).into(gif)
                        MediaPlayer.create(this, R.raw.win).start()

                        Handler().postDelayed({
                            timer()

                        }, 11000)
                    }
                    3 -> {
                        Glide.with(this).load(R.drawable.gif2).into(gif)
                        MediaPlayer.create(this, R.raw.win).start()

                        Handler().postDelayed({
                            timer()

                        }, 11000)
                    }
                    4 -> {
                        Glide.with(this).load(R.drawable.gif3).into(gif)
                        MediaPlayer.create(this, R.raw.win).start()

                        Handler().postDelayed({
                            timer()

                        }, 11000)
                    }
                    5 -> {
                        Glide.with(this).load(R.drawable.gif5).into(gif)
                        MediaPlayer.create(this, R.raw.win).start()

                        Handler().postDelayed({
                            timer()

                        }, 11000)
                    }
                    6 -> {
                        Glide.with(this).load(R.drawable.gif6).into(gif)
                        MediaPlayer.create(this, R.raw.win).start()

                        Handler().postDelayed({
                            timer()

                        }, 11000)
                    }
                    7 -> {
                        Glide.with(this).load(R.drawable.gif7).into(gif)
                        MediaPlayer.create(this, R.raw.win).start()

                        Handler().postDelayed({
                            timer()

                        }, 11000)
                    }
                    8 -> {
                        Glide.with(this).load(R.drawable.gif8).into(gif)
                        MediaPlayer.create(this, R.raw.win).start()

                        Handler().postDelayed({
                            timer()

                        }, 11000)
                    }
                    9 -> {
                        Glide.with(this).load(R.drawable.gif9).into(gif)
                        MediaPlayer.create(this, R.raw.win).start()

                        Handler().postDelayed({
                            timer()

                        }, 11000)
                    }
                    else -> {
                        Glide.with(this).load(R.drawable.gif).into(gif)
                        MediaPlayer.create(this, R.raw.win).start()

                        Handler().postDelayed({
                            timer()

                        }, 11000)
                    }


                }


            } else {
                Toast.makeText(this, "Хато", Toast.LENGTH_LONG).show()
                MediaPlayer.create(this, R.raw.lose).start()
            }
        }
    }

    override fun onStartDrag(viewHolder: RecyclerView.ViewHolder) {
        touchHelper.startDrag(viewHolder)
    }

    private fun populateListItem() {
        var a = (0..30).random()
     //   var b = (18..35).random()
        var b = a + 5

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

    fun timer() {
gif.setImageDrawable(null)

    }


}
