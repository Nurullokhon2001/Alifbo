package com.encom.dynamicview.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.encom.dynamicview.repository.model.AlphabetButtonModel
import com.encom.dynamicview.vm.AlphabetMainCviewViewModel
import com.encom.dynamicview.vm.HamsadoMainCviewViewModel
import com.example.tajikenglish.R


class HamsadoMainCviewFragment : Fragment(), View.OnClickListener {
    private lateinit var linearLayout: LinearLayout
    private lateinit var cviewViewModelAlphabet: HamsadoMainCviewViewModel

    var indexarray: Int = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)
        cviewViewModelAlphabet = ViewModelProvider(this).get(HamsadoMainCviewViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_alphabet_main_view_fragment, container, false)
        linearLayout = view.findViewById<LinearLayout>(R.id.linearLayout)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initializeViews(cviewViewModelAlphabet.getAlphabets())
    }

    override fun onClick(v: View?) {
        v?.let {
            val alphabetCviewModel: AlphabetButtonModel = it.getTag() as AlphabetButtonModel
            var index: Int = indexarray - alphabetCviewModel.id


            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment, HamsadoCviewFragment.newInstance(alphabetCviewModel)).commit()

        }
    }

    fun initializeViews(alphabetCviewModels: ArrayList<AlphabetButtonModel>) {
        alphabetCviewModels.forEachIndexed { index, alphabetModel ->
            val itemView: View =
                layoutInflater.inflate(R.layout.item_alphabet_main_cview_fragment_view, linearLayout, false)
            itemView.findViewById<TextView>(R.id.textView).text = alphabetModel.alphabet
            itemView.setOnClickListener(this)
            itemView.setTag(alphabetModel)
            indexarray = index
            linearLayout.addView(itemView)

        }
    }

}