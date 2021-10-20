package com.example.tajikenglish.MainMenu.View

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tajikenglish.Alphabet.AlphabetActivity
import com.example.tajikenglish.DrawActivity
import com.example.tajikenglish.Number.NumberActivity
import com.example.tajikenglish.Order.OrderActivity
import com.example.tajikenglish.R
import com.example.tajikenglish.MainMenu.adaptors.EngTopicAdapter
import com.example.tajikenglish.MainMenu.ViewModel.MainViewModel
import com.example.tajikenglish.repository.MainRepositoryImpl


class MainFragment : Fragment(), View.OnClickListener {
    lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EngTopicAdapter
    private lateinit var viewModel:MainViewModel
    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mainn, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = EngTopicAdapter(requireContext(), viewModel.getMenu(), this)
        recyclerView.adapter = adapter
    }

    override fun onClick(v: View) {
        when (v.tag.toString()) {
            MainRepositoryImpl.ALIFBO -> {
                val intent = Intent(context, AlphabetActivity::class.java)
                startActivity(intent)
            }
            MainRepositoryImpl.RAQAMHO -> {
                val intent = Intent(context, NumberActivity::class.java)
                startActivity(intent)
            }
            MainRepositoryImpl.RASMKASHI -> {
                val intent = Intent(context, DrawActivity::class.java)
                startActivity(intent)
            }
            MainRepositoryImpl.TARTIB -> {

                val intent = Intent(context, OrderActivity::class.java)
                startActivity(intent)
               // Toast.makeText(context, "vkladka tartib", Toast.LENGTH_SHORT).show()
            }
            MainRepositoryImpl.KALIMASOZI -> {
                Toast.makeText(context, "vkladka kalimasozi", Toast.LENGTH_SHORT).show()
            }
            MainRepositoryImpl.KALIMAYOBI -> {
                Toast.makeText(context, "vkladka kalimayobi", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
