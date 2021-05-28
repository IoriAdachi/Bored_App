package com.example.boredapp.Deep

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.opengl.GLSurfaceView
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.boredapp.R
import com.mukesh.imageproccessing.OnProcessingCompletionListener
import com.mukesh.imageproccessing.PhotoFilter
import com.mukesh.imageproccessing.filters.*
import kotlinx.android.synthetic.main.activity_deep_fry.*


class DeepFry : AppCompatActivity(), OnProcessingCompletionListener {

    private lateinit var result: Bitmap

    override fun onProcessingComplete(bitmap: Bitmap) {
        // Do anything with the bitmap save it or add another effect to it
        result = bitmap
    }

    private var photoFilter:PhotoFilter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deep_fry)
        //Log.d(TAG, "broken")
        photoFilter = PhotoFilter(effectView,this)
        photoFilter?.applyEffect(BitmapFactory.decodeResource(resources, R.drawable.sadface), Contrast(800F))
    }

}



    /*private val TAG = "deep fry"
    var bitmap: Bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.sadface)
    var imageView: ImageView = findViewById(R.id.imageView)


    private var photoFilter = PhotoFilter(effectsView = GLSurfaceView(this), object: OnProcessingCompletionListener{
        override fun onProcessingComplete(bitmap: Bitmap) {
            // Do anything with the bitmap save it or add another effect to it
        }
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deep_fry)
        Log.d(TAG, "broken")

        photoFilter?.applyEffect(bitmap,AutoFix())


        //photoFilter?.applyEffect(bitmap,Saturate())

        imageView.setImageBitmap(bitmap)

    }*/
