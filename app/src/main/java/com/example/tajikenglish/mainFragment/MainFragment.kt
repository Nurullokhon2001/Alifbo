package com.example.tajikenglish

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tajikenglish.Alphabet.AlphabetActivity
import com.example.tajikenglish.Number.NumberActivity
import com.example.tajikenglish.Order.OrderActivity
import com.example.tajikenglish.mainFragment.adaptors.EngTopicAdapter
import com.example.tajikenglish.mainFragment.model.MainRepository


class MainnFragment : Fragment(), View.OnClickListener {
    lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EngTopicAdapter

    val repository = MainRepository()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.fragment_mainn, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        val ic = MainRepository()


        adapter = EngTopicAdapter(requireContext(), ic.getMenu(), this)
        recyclerView.adapter = adapter




        return view
    }

    override fun onClick(v: View) {
        when (v.tag.toString()) {
            MainRepository.ALIFBO -> {
                val intent = Intent(context, AlphabetActivity::class.java)
                startActivity(intent)
            }
            MainRepository.RAQAMHO -> {
                val intent = Intent(context, NumberActivity::class.java)
                startActivity(intent)
            }
            MainRepository.RASMKASHI -> {
                val intent = Intent(context, DrawActivity::class.java)
                startActivity(intent)
            }
            MainRepository.TARTIB -> {

                val intent = Intent(context, OrderActivity::class.java)
                startActivity(intent)
               // Toast.makeText(context, "vkladka tartib", Toast.LENGTH_SHORT).show()
            }
            MainRepository.KALIMASOZI -> {
                Toast.makeText(context, "vkladka kalimasozi", Toast.LENGTH_SHORT).show()
            }
            MainRepository.KALIMAYOBI -> {
                Toast.makeText(context, "vkladka kalimayobi", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
