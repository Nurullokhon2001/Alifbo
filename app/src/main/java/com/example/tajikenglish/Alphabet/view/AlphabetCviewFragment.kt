package com.encom.dynamicview.view

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.encom.dynamicview.repository.model.AlphabetButtonModel
import com.encom.dynamicview.repository.model.AlphabetImageWordModel
import com.encom.dynamicview.vm.AlphabetCviewViewModel
import com.example.tajikenglish.R
import java.io.InputStream


class AlphabetCviewFragment : Fragment(), View.OnClickListener {
    private lateinit var linearLayout: LinearLayout
    private lateinit var viewModel: AlphabetCviewViewModel

    var itemAlphabet: Int = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(this).get(AlphabetCviewViewModel::class.java)
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

        initializeViews(viewModel.getAlphabets(itemAlphabet))
    }

    override fun onClick(v: View?) {
        v?.let {
            val alphabetModel: AlphabetImageWordModel = it.getTag() as AlphabetImageWordModel
            when(it.id){
                R.id.ImageView->{

                }
                R.id.alpabetView->{

                }
                R.id.wordtView->{

                }
            }
            Toast.makeText(requireContext(), alphabetModel.alphabet, Toast.LENGTH_SHORT).show()
        }
    }

    fun initializeViews(alphabets: AlphabetImageWordModel) {
        val itemView: View = layoutInflater.inflate(R.layout.item_view_alphabet_cview, linearLayout, false)
        itemView.findViewById<TextView>(R.id.alpabetView).apply {
            text = alphabets.alphabet
            setOnClickListener(this@AlphabetCviewFragment)
            setTag(alphabets)
        }
        itemView.findViewById<ImageView>(R.id.ImageView).apply {
            val inputStream: InputStream = requireContext().getAssets().open("rasmho/" +alphabets.ImageVIew)
            val image = Drawable.createFromStream(inputStream, null)
            setImageDrawable(image)
            setOnClickListener(this@AlphabetCviewFragment)
            setTag(alphabets)
        }
        itemView.findViewById<TextView>(R.id.wordtView).apply {
            text = alphabets.word
            setTag(alphabets)
        }
        linearLayout.addView(itemView)
    }

    companion object {
        fun newInstance(itemContact: AlphabetButtonModel): AlphabetCviewFragment {

            val fragment = AlphabetCviewFragment()
            fragment.itemAlphabet = itemContact.id
            return fragment
        }


    }
}
