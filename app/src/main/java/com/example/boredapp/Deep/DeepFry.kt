package com.example.boredapp.Deep

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.boredapp.R
import com.mukesh.imageproccessing.OnProcessingCompletionListener
import com.mukesh.imageproccessing.PhotoFilter
import com.mukesh.imageproccessing.filters.*
import kotlinx.android.synthetic.main.activity_deep_fry.*


class DeepFry : AppCompatActivity(), OnProcessingCompletionListener, OnFilterClickListener {

    private lateinit var result: Bitmap
    private var photoFilter:PhotoFilter?=null
    override fun onProcessingComplete(bitmap: Bitmap) {
        // Do anything with the bitmap save it or add another effect to it
        result = bitmap
    }

    override fun onFilterClicked(effectsThumbnail: EffectsThumbnail) {
        photoFilter?.applyEffect(
            BitmapFactory.decodeResource(resources, R.drawable.sadface), effectsThumbnail.filter
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deep_fry)
        //Log.d(TAG, "broken")
        intialize()
        button_filter_activate.setOnClickListener {
            filter()
        }

    }

    fun intialize(){
        imageView_filter_original.setVisibility(View.INVISIBLE)
        photoFilter = PhotoFilter(effectView, this)
        photoFilter?.applyEffect(BitmapFactory.decodeResource(resources, R.drawable.sadface), None())
        effectsRecyclerView.layoutManager =
            LinearLayoutManager(this@DeepFry, RecyclerView.HORIZONTAL, false)
        effectsRecyclerView.setHasFixedSize(true)
        effectsRecyclerView.adapter = EffectsAdapter(getItems(), this@DeepFry)

    }

    fun filter(){
        imageView_filter_original.setVisibility(View.INVISIBLE)
        photoFilter?.applyEffect(BitmapFactory.decodeResource(resources, R.drawable.sadface), Contrast(800F))
    }

    private fun getItems(): MutableList<EffectsThumbnail> {
        return mutableListOf(
            EffectsThumbnail("None", None()),
            EffectsThumbnail("AutoFix", AutoFix()),
            EffectsThumbnail("Highlight", Highlight()),
            EffectsThumbnail("Brightness", Brightness()),
            EffectsThumbnail("Contrast", Contrast()),
            EffectsThumbnail("Cross Process", CrossProcess()),
            EffectsThumbnail("Documentary", Documentary()),
            EffectsThumbnail("Duo Tone", DuoTone()),
            EffectsThumbnail("Fill Light", FillLight()),
            EffectsThumbnail("Fisheye", FishEye()),
            EffectsThumbnail("Flip Horizontally", FlipHorizontally()),
            EffectsThumbnail("Flip Vertically", FlipVertically()),
            EffectsThumbnail("Grain", Grain()),
            EffectsThumbnail("Grayscale", Grayscale()),
            EffectsThumbnail("Lomoish", Lomoish()),
            EffectsThumbnail("Negative", Negative()),
            EffectsThumbnail("Posterize", Posterize()),
            EffectsThumbnail("Rotate", Rotate()),
            EffectsThumbnail("Saturate", Saturate()),
            EffectsThumbnail("Sepia", Sepia()),
            EffectsThumbnail("Sharpen", Sharpen()),
            EffectsThumbnail("Temperature", Temperature()),
            EffectsThumbnail("Tint", Tint()),
            EffectsThumbnail("Vignette", Vignette())
        )
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
