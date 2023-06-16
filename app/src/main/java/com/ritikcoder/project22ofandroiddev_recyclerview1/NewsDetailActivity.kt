package com.ritikcoder.project22ofandroiddev_recyclerview1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ritikcoder.project22ofandroiddev_recyclerview1.databinding.ActivityNewsDetailBinding

class NewsDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityNewsDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityNewsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //getting values from the MainActivity2.
        val newsImage= intent.getIntExtra("image", R.drawable.greet_image1)
        val newsHeading= intent.getStringExtra("heading")
        val newsContent= intent.getStringExtra("content")

        //setting data into the fields.
        binding.imageViewForNewsImage.setImageResource(newsImage)
        binding.textViewForNewsHeading.text= newsHeading
        binding.textViewForNewsContent.text= newsContent

    }
}