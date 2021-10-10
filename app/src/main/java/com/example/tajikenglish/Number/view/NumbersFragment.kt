package com.example.tajikenglish.Number.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.tajikenglish.Alphabet.repository.model.AlphabetsModel
import com.example.tajikenglish.R

class NumbersFragment : Fragment(), View.OnClickListener {

    private lateinit var linearLayout: LinearLayout
     var array: ArrayList<AlphabetsModel> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_numbers, container, false)
        linearLayout = view.findViewById(R.id.linearLayout)



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews(array)
    }

    private fun initializeViews(alphabetModels: ArrayList<AlphabetsModel>) {
        for (alphabetModel in alphabetModels) {
            val itemView: View =
                layoutInflater.inflate(R.layout.item_alphabet_main_cview_fragment_view,
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
                .replace(R.id.fragment, NumbersDetailsFragment.newInstance(alphabetModel))
                .commit()

        }
    }

    companion object {
        fun newInstance(itemAlpabets: ArrayList<AlphabetsModel>): NumbersFragment {

            val fragment = NumbersFragment()
            fragment.array = itemAlpabets
            return fragment
        }

    }


}