package com.example.tajikenglish

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.encom.dynamicview.repository.model.AlphabetModel
import com.encom.dynamicview.vm.MainViewModel


class AlphabetButtonDrawFragment : Fragment(), View.OnClickListener {
    private lateinit var linearLayout: LinearLayout
    private lateinit var viewModel: MainViewModel

    var indexarray :Int = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_alpabet_draw_button, container, false)
        linearLayout = view.findViewById<LinearLayout>(R.id.linearLayout)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initializeViews(viewModel.getAlphabets())
    }

    override fun onClick(v: View?) {
        v?.let {
            val alphabet: AlphabetModel = it.getTag() as AlphabetModel

requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragment,AlphabetDrawFragment.newInstance(alphabet)).commit()


        }
    }

    fun initializeViews(alphabets: ArrayList<AlphabetModel>) {
        alphabets.forEachIndexed { index, alphabetModel ->
            val itemView: View = layoutInflater.inflate(R.layout.item_button_view,linearLayout,false)
            itemView.findViewById<TextView>(R.id.textView).text = alphabetModel.alphabet
            itemView.setOnClickListener(this)
            itemView.setTag(alphabetModel)
            indexarray = index
            linearLayout.addView(itemView)

        }






//        for (item in alphabets) {
//            val itemView: View = layoutInflater.inflate(R.layout.item_button_view,linearLayout,false)
//            itemView.findViewById<TextView>(R.id.textView).text = item.alphabet
//            itemView.setOnClickListener(this)
//            itemView.setTag(item)
//            linearLayout.addView(itemView)
//        }
    }

}