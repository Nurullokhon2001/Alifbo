package com.example.tajikenglish.alphabet.view

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
import androidx.lifecycle.ViewModelProvider

import com.example.tajikenglish.modules.AlphabetsModel
import com.example.tajikenglish.alphabet.vm.AlphabetsViewModel
import com.example.tajikenglish.R
import kotlinx.android.synthetic.main.fragment_alphabets_details.view.*
import java.io.InputStream

class AlphabetsDetailsFragment : Fragment(), View.OnClickListener {
    private lateinit var alphabet: TextView
    private lateinit var image: ImageView
    private lateinit var word: TextView
    private lateinit var vm: AlphabetsViewModel
    var mp: MediaPlayer? = null
    var alphabetArray: AlphabetsModel =
        (AlphabetsModel(0, "А а", "Анор", "rasmho/anor.jpg", "1.mp3", "rasmho/anor.mp3", 1))

    override fun onAttach(context: Context) {
        super.onAttach(context)
        vm = ViewModelProvider(this).get(AlphabetsViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_alphabets_details, container, false)
        alphabet = view.findViewById(R.id.alhpabet)
        image = view.findViewById(R.id.image)
        word = view.findViewById(R.id.word)




        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews(alphabetArray)


    }

    private fun initializeViews(alphabets: AlphabetsModel) {

        alphabet.apply {
            text = alphabets.alphabet
            setOnClickListener(this@AlphabetsDetailsFragment)
            setTag(alphabets)
        }
        image.apply {
            val inputStream: InputStream =
                requireContext().getAssets().open(alphabets.image)
            val image = Drawable.createFromStream(inputStream, null)
            setImageDrawable(image)
            setOnClickListener(this@AlphabetsDetailsFragment)
            setTag(alphabets)
        }
        word.apply {
            text = alphabets.word
            setTag(alphabets)
        }
    }

    override fun onClick(v: View?) {

        v?.let {
            val alphabetModel: AlphabetsModel = it.getTag() as AlphabetsModel
            when (it.id) {
                R.id.image -> {

                    audioPlayer(alphabetModel.imagePlayer)

                }
                R.id.alhpabet -> {

                    audioPlayer(alphabetModel.alphabetPlayer)

                }

            }

        }
    }

    fun audioPlayer(fullPath: String) {
        try {
            if (mp != null) {
                mp?.stop()
                mp?.release()
                mp = null
            }
            mp = MediaPlayer()
            val decs: AssetFileDescriptor = requireContext().resources.assets.openFd(fullPath)
            mp?.setDataSource(decs.fileDescriptor, decs.startOffset, decs.length)
            decs.close()
            mp?.prepare()
            mp?.setVolume(1f, 1f)
            mp?.isLooping = false

            mp?.start()
        } catch (ex: Exception) {
            Log.i("", ex.message!!)
        }
    }


    companion object {
        fun newInstance(itemContact: AlphabetsModel): AlphabetsDetailsFragment {

            val fragment = AlphabetsDetailsFragment()
            fragment.alphabetArray = itemContact
            return fragment
        }
    }
}