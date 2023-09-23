package com.example.tajikenglish

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.tajikenglish.modules.models.DrawModel
import com.encom.dynamicview.vm.DrawViewModel



class AlphabetButtonDrawFragment : Fragment(), View.OnClickListener {
    private lateinit var linearLayout: LinearLayout
    private lateinit var viewModel: DrawViewModel
    var alphabetArray: ArrayList<DrawModel> = ArrayList()

    var indexarray: Int = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(this).get(DrawViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_alpabet_draw_button, container, false)
        linearLayout = view.findViewById<LinearLayout>(R.id.linearLayout)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initializeViews(alphabetArray)
    }



    override fun onClick(v: View?) {
        v?.let {
            val alphabet: DrawModel = it.getTag() as DrawModel

            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment, AlphabetDrawFragment.newInstance(alphabet)).commit()






        }
    }

    private fun initializeViews(alphabetModels: ArrayList<DrawModel>) {
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

    companion object {
        fun newInstance(itemAlpabets: ArrayList<DrawModel>): AlphabetButtonDrawFragment {

            val fragment = AlphabetButtonDrawFragment()
            fragment.alphabetArray = itemAlpabets
            return fragment
        }

    }
    }

