package com.example.tajikenglish.alphabet.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.tajikenglish.modules.AlphabetsModel
import com.example.tajikenglish.R

class AlphabetsFragment : Fragment(), View.OnClickListener {

    private lateinit var linearLayout: LinearLayout
     var numberArray: ArrayList<AlphabetsModel> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_alphabets, container, false)
        linearLayout = view.findViewById(R.id.linearLayout)



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews(numberArray)
    }

    private fun initializeViews(alphabetModels: ArrayList<AlphabetsModel>) {
        for (alphabetModel in alphabetModels) {
            val itemView: View =
                layoutInflater.inflate(R.layout.item_button_view,
                    linearLayout,
                    false)
            itemView.findViewById<TextView>(R.id.textView).text = alphabetModel.alphabet
            itemView.setOnClickListener(this)
            itemView.setTag(alphabetModel)
            linearLayout.addView(itemView)
        }
    }

    override fun onClick(v: View?) {
        v?.let {
            val alphabetModel: AlphabetsModel = it.getTag() as AlphabetsModel


            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment, AlphabetsDetailsFragment.newInstance(alphabetModel))
                .commit()

        }
    }

    companion object {
        fun newInstance(itemAlpabets: ArrayList<AlphabetsModel>): AlphabetsFragment {

            val fragment = AlphabetsFragment()
            fragment.numberArray = itemAlpabets
            return fragment
        }

    }


}