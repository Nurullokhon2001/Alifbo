package com.example.tajikenglish.modules.main_menu.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tajikenglish.DrawActivity
import com.example.tajikenglish.number.NumberActivity
import com.example.tajikenglish.order.OrderActivity
import com.example.tajikenglish.R
import com.example.tajikenglish.alphabet.AlphabetActivity
import com.example.tajikenglish.modules.find_alphabet_activty.TestAlphabetActivity
import com.example.tajikenglish.modules.harfyobi_test.TestHarfyobi
import com.example.tajikenglish.modules.main_menu.adapter.MenuAdapter
import com.example.tajikenglish.modules.main_menu.view_model.MainViewModel
import com.example.tajikenglish.repository.MainRepositoryImpl
import com.example.tajikenglish.settings.SettingsFragment


class MainFragment : Fragment(), View.OnClickListener {
    lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MenuAdapter
    private lateinit var viewModel: MainViewModel
    private lateinit var settings: ImageView
    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mainn, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        settings=view.findViewById(R.id.settings)
        settings.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container,SettingsFragment()).addToBackStack(SettingsFragment()::class.java.simpleName).commit()
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = MenuAdapter(requireContext(), viewModel.getMenu(), this)
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

            }
            MainRepositoryImpl.KALIMASOZI -> {
                val intent = Intent(context, TestAlphabetActivity::class.java)
                startActivity(intent)
            }
            MainRepositoryImpl.KALIMAYOBI -> {
                val intent = Intent(context, TestHarfyobi::class.java)
                startActivity(intent)
            }
        }
    }
}
