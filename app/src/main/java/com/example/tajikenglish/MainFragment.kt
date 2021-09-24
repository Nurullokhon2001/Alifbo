package com.example.tajikenglish

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.tajikenglish.Alphabet.AlphabetActivity


class MainFragment : Fragment() {
    lateinit var  alphabetFragment : LinearLayout
   lateinit var  drawview : LinearLayout
//    lateinit var  numberFragment : LinearLayout
//    lateinit var  unitFragment : LinearLayout
//    lateinit var wordsFragment: LinearLayout
//    lateinit var phrasesFragment: LinearLayout
//    lateinit var speechFragment: LinearLayout



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_main, container, false)
        alphabetFragment=view.findViewById(R.id.alphabetlayout2)
        alphabetFragment.setOnClickListener {
            val intent = Intent(context,AlphabetActivity::class.java)
            startActivity(intent)
        }
        drawview=view.findViewById(R.id.DrawView)
        drawview.setOnClickListener {
            val intent = Intent(context,DrawActivity::class.java)
            startActivity(intent)
        }
        return view

    }


    }
