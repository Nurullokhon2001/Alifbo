package com.example.tajikenglish.Number.view

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.tajikenglish.Alphabet.vm.AlphabetsViewModel
import com.example.tajikenglish.Number.Model.NumbersModel
import com.example.tajikenglish.R
import kotlinx.android.synthetic.main.fragment_alphabets_details.view.*
import java.io.InputStream

class NumbersDetailsFragment : Fragment(), View.OnClickListener {
    private lateinit var alphabet: TextView
    private lateinit var image: ImageView
    private lateinit var word: TextView
    private lateinit var vm: AlphabetsViewModel
    var array: NumbersModel =
        (NumbersModel(0, "А а", "Анор", "rasmho/anor.jpg", "1.mp3", "rasmho/anor.mp3", 1))

    override fun onAttach(context: Context) {
        super.onAttach(context)
        vm = ViewModelProvider(this).get(AlphabetsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_numbers_details, container, false)
        alphabet = view.findViewById(R.id.number)
        image = view.findViewById(R.id.image)
        word = view.findViewById(R.id.word)




        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews(array)


    }

    fun initializeViews(alphabets: NumbersModel) {

        alphabet.apply {
            text = alphabets.number
            setOnClickListener(this@NumbersDetailsFragment)
            setTag(alphabets)
        }
        image.apply {

            val inputStream: InputStream =
                requireContext().getAssets().open(alphabets.image)
            val image = Drawable.createFromStream(inputStream, null)
            setImageDrawable(image)

            setOnClickListener(this@NumbersDetailsFragment)
            setTag(alphabets)
        }
        word.apply {
            text = alphabets.word
            setTag(alphabets)
        }
    }

    override fun onClick(v: View?) {

        v?.let {
            val alphabetModel: NumbersModel = it.getTag() as NumbersModel
            when (it.id) {
                R.id.number -> {
                    Toast.makeText(requireContext(),alphabetModel.number , Toast.LENGTH_SHORT).show()
                }
                R.id.image -> {
                    Toast.makeText(requireContext(),alphabetModel.numberPlayer , Toast.LENGTH_SHORT).show()
                }
                R.id.image -> {

                    Toast.makeText(requireContext(),alphabetModel.imagePlayer , Toast.LENGTH_SHORT).show()

                }
            }
        }
    }

    companion object {
        fun newInstance(itemContact: NumbersModel): NumbersDetailsFragment {

            val fragment = NumbersDetailsFragment()
            fragment.array = itemContact
            return fragment
        }
    }
}