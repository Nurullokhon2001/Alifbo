package com.example.tajikenglish

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import com.example.tajikenglish.modules.DrawModel
import com.example.tajikenglish.modules.DrawImageModel
import com.encom.dynamicview.vm.DrawViewModel
import java.io.InputStream


class AlphabetDrawFragment : Fragment(), View.OnClickListener {
    private lateinit var linearLayout: LinearLayout
    private lateinit var viewModel: DrawViewModel

    var itemAlphabet: Int = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(this).get(DrawViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_alphabet_draw, container, false)
        linearLayout = view.findViewById<LinearLayout>(R.id.linearLayout)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        initializeViews(viewModel.getDrawAlphabetsImage(itemAlphabet))
    }

    override fun onClick(v: View?) {
        v?.let {
//            var alphabet: SecondModel = it.getTag() as SecondModel
//            var imageView = alphabet.ImageVIew
//            linearLayout.setBackgroundResource(imageView)

        }
    }

    fun initializeViews(alphabets: DrawImageModel) {

        val itemView: View = layoutInflater.inflate(R.layout.item_second_view, linearLayout, false)


        val inputStream: InputStream = requireContext().getAssets().open(alphabets.ImageVIew)
        val image = Drawable.createFromStream(inputStream, null)


        itemView.findViewById<ImageView>(R.id.ImageView).setImageDrawable(image)


        itemView.setOnClickListener(this)
        itemView.setTag(alphabets)
        linearLayout.addView(itemView)

    }

    companion object {
        fun newInstance(itemContact: DrawModel): AlphabetDrawFragment {

            val fragment = AlphabetDrawFragment()
            fragment.itemAlphabet = itemContact.id
            return fragment
        }


    }
}
