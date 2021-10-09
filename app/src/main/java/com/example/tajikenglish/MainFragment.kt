package com.example.tajikenglish

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.tajikenglish.Alphabet.AlphabetActivity
import com.example.tajikenglish.Number.NumberActivity


class MainFragment : Fragment() {
    private lateinit var alphabetFragment: LinearLayout
    private lateinit var drawer: LinearLayout
    private lateinit var numbersLayout: LinearLayout


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_mainn, container, false)
        alphabetFragment = view.findViewById(R.id.alphabetlayout2)
        alphabetFragment.setOnClickListener {
            val intent = Intent(context, AlphabetActivity::class.java)
            startActivity(intent)
        }
        drawer = view.findViewById(R.id.DrawView)
        drawer.setOnClickListener {
            val intent = Intent(context, DrawActivity::class.java)
            startActivity(intent)
        }
        numbersLayout = view.findViewById(R.id.NumbersLayout)
        numbersLayout.setOnClickListener {
            val intent = Intent(context, NumberActivity::class.java)
            startActivity(intent)

        }




        return view
    }

}
