package com.example.tajikenglish.number.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.tajikenglish.modules.models.NumbersModel
import com.example.tajikenglish.R

class NumbersFragment : Fragment(), View.OnClickListener {

    private lateinit var linearLayout: LinearLayout
     var array: ArrayList<NumbersModel> = ArrayList()


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

    private fun initializeViews(alphabetModels: ArrayList<NumbersModel>) {
        for (alphabetModel in alphabetModels) {
            val itemView: View =
                layoutInflater.inflate(R.layout.item_button_view,
                    linearLayout,
                    false)
            itemView.findViewById<TextView>(R.id.textView).text = alphabetModel.number.toString()
            itemView.setOnClickListener(this)
            itemView.setTag(alphabetModel)
            linearLayout.addView(itemView)
        }
    }

    override fun onClick(v: View?) {
        v?.let {
            val alphabetModel: NumbersModel = it.getTag() as NumbersModel


            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment, NumbersDetailsFragment.newInstance(alphabetModel))
                .commit()

        }
    }

    companion object {
        fun newInstance(itemAlpabets: ArrayList<NumbersModel>): NumbersFragment {

            val fragment = NumbersFragment()
            fragment.array = itemAlpabets
            return fragment
        }

    }


}