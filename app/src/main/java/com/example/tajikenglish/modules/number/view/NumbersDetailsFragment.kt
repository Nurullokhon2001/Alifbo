package com.example.tajikenglish.number.view

import android.content.Context
import android.content.res.AssetFileDescriptor
import android.graphics.drawable.Drawable
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.tajikenglish.modules.models.NumbersModel
import com.example.tajikenglish.R
import kotlinx.android.synthetic.main.fragment_alphabets_details.view.*
import java.io.InputStream

class NumbersDetailsFragment : Fragment(), View.OnClickListener {
    private lateinit var alphabet: TextView
    private lateinit var image: ImageView
    private lateinit var word: TextView
    var mp:MediaPlayer? = null

    var array: NumbersModel =
        (NumbersModel(0, 1, "Анор", "rasmho/anor.jpg", "1.mp3", "rasmho/anor.mp3", 1))

    override fun onAttach(context: Context) {
        super.onAttach(context)

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
            text = alphabets.number.toString()
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
            val numbersModel: NumbersModel = it.getTag() as NumbersModel
            when (it.id) {
                R.id.number -> {
                    audioPlayer(numbersModel.numberPlayer)
                }
                R.id.image -> {
                    Toast.makeText(requireContext(),numbersModel.imagePlayer , Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

    fun audioPlayer(fullPath:String){
        try {
            if (mp!=null){
                mp?.stop()
                mp?.release()
                mp= null
            }
            mp = MediaPlayer()
            val decs: AssetFileDescriptor = requireContext().resources.assets.openFd(fullPath)
            mp?.setDataSource(decs.fileDescriptor,decs.startOffset,decs.length)
            decs.close()
            mp?.prepare()
            mp?.setVolume(1f,1f)
            mp?.isLooping=false

            mp?.start()
        }catch (ex:Exception){
            Log.i("",ex.message!!)
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