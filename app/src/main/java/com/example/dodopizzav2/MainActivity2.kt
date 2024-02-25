package com.dodopizza
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.dodopizzav2.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    companion object {
        const val KEY_RESULT = "KeyResult"
        const val KEY_DESCRIPTION = "KeyIngredient"
        const val KEY_IMAGE = "KeyImageUrl"
        const val KEY_SIZE = "KeySize"
        const val KEY_CART = "KeyCart"
    }
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val result = intent.getStringExtra(KEY_RESULT)
        val resultDes = intent.getStringExtra(KEY_DESCRIPTION)
        val resultImage = intent.getIntExtra(KEY_IMAGE, 0)
        val resultSz = intent.getStringExtra(KEY_SIZE)
        val resultcart = intent.getStringExtra(KEY_CART)

        binding.resultTextView.text = result
        binding.resultDescription.text = resultDes
        binding.resultSize.text = resultSz
        binding.resultCart.text = resultcart

        Glide.with(this)
            .load(resultImage) // Load the image from the URL
            .into(binding.imageView)

        binding.goback.setOnClickListener {
            // Navigate back to the first activity
            onBackPressed()
        }

    }
}
