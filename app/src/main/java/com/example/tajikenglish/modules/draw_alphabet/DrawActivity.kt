package com.example.tajikenglish

import android.Manifest
import android.annotation.SuppressLint
import android.app.Dialog
import android.app.ProgressDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.media.MediaScannerConnection
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.get

import kotlinx.android.synthetic.main.activity_draw.*
import kotlinx.android.synthetic.main.dialog_brush_size.*

import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream

class DrawActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_draw)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, AlphabetButtonDrawFragment())
            .commit()
        supportFragmentManager.beginTransaction().replace(R.id.fragment, AlphabetDrawFragment())
            .commit()


    }
}