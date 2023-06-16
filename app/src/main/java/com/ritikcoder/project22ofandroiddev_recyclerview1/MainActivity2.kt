package com.ritikcoder.project22ofandroiddev_recyclerview1

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.ritikcoder.project22ofandroiddev_recyclerview1.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    lateinit var binding: ActivityMain2Binding

    private lateinit var myRecyclerView: RecyclerView
    private lateinit var newsArrayList: ArrayList<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        

        //Data Creating For My Activity
        val newsImageArray= arrayOf(R.drawable.img_0, R.drawable.img_1,
            R.drawable.img_2, R.drawable.img_3,
            R.drawable.img_4, R.drawable.img_5,
            R.drawable.img_6, R.drawable.img_7,
            R.drawable.img_8, R.drawable.img_9,
            R.drawable.img_10, R.drawable.img_11,
            R.drawable.img_12, R.drawable.img_13,
            R.drawable.img_14, R.drawable.img_15,
            R.drawable.img_16, R.drawable.img_17,
            R.drawable.img_18, R.drawable.img_19,
            R.drawable.img_20)
        val newsHeadingArray= arrayOf("Video provides a powerful way to help you prove your point. " +
                "When you click Online Video, you can paste ",
            "in the embed code for the video you want to add. You can also type a keyword to search online for the ",
            "To make your document look professionally produced, Word provides header, footer, cover page, and ",
            "text box designs that complement each other. For example, you can add a matching cover page, header, ",
            "and sidebar. Click Insert and then choose the elements you want from the different galleries.",
            "Themes and styles also help keep your document coordinated. When you click Design and choose a new ",
            "Theme, the pictures, charts, and SmartArt graphics change to match your new theme. When you apply ",
            "and sidebar. Click Insert and then choose the elements you want from the different galleries.",
            "Themes and styles also help keep your document coordinated. When you click Design and choose a new ",
            "Theme, the pictures, charts, and SmartArt graphics change to match your new theme. When you apply ",
            "To make your document look professionally produced, Word provides header, footer, cover page, and ",
            "text box designs that complement each other. For example, you can add a matching cover page, header, ",
            "and sidebar. Click Insert and then choose the elements you want from the different galleries.",
            "Themes and styles also help keep your document coordinated. When you click Design and choose a new ",
            "Theme, the pictures, charts, and SmartArt graphics change to match your new theme. When you apply ",
            "and sidebar. Click Insert and then choose the elements you want from the different galleries.",
            "Themes and styles also help keep your document coordinated. When you click Design and choose a new ",
            "Theme, the pictures, charts, and SmartArt graphics change to match your new theme. When you apply ",
            "and sidebar. Click Insert and then choose the elements you want from the different galleries.",
            "Themes and styles also help keep your document coordinated. When you click Design and choose a new ",
            "Theme, the pictures, charts, and SmartArt graphics change to match your new theme. When you apply "
        )
        val personNameArray= arrayOf("Ritik verma", "Sundar pichai", "Rihit sharma", "Priyanka chopra",
            "Hritik roshan", "Kajal agrawal", "Vijay sharma", "Elon musk", "Shruti kumari", "Kajal", "Name1",
            "Name2", "Name3", "Name4", "Name5", "Name6", "Name7", "Name8", "Name9", "Name10", "Name11"
        )
        val newsContentArray= arrayOf(getString(R.string.newsContent), getString(R.string.newsContent),
            getString(R.string.newsContent), getString(R.string.newsContent), getString(R.string.newsContent),
            getString(R.string.newsContent), getString(R.string.newsContent), getString(R.string.newsContent),
            getString(R.string.newsContent), getString(R.string.newsContent), getString(R.string.newsContent),
            getString(R.string.newsContent), getString(R.string.newsContent), getString(R.string.newsContent),
            getString(R.string.newsContent), getString(R.string.newsContent), getString(R.string.newsContent),
            getString(R.string.newsContent), getString(R.string.newsContent), getString(R.string.newsContent),
            getString(R.string.newsContent))

        myRecyclerView= binding.recyclerView

        //To set hav bhav of items inside recyclerView like:- vertically scrolling, horizontally, uniform grid
        myRecyclerView.layoutManager= LinearLayoutManager(this)

        newsArrayList= arrayListOf<News>()

        //foreach loop to prepare data
        for(index in newsImageArray.indices){
            val news= News(newsHeadingArray[index], newsImageArray[index], personNameArray[index], newsContentArray[index])
            newsArrayList.add(news)
        }

        val myAdapter= MyAdapter(newsArrayList, this)
        myRecyclerView.adapter= myAdapter

        myAdapter.setOnItemClickListener(object: MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                //on Clicking each item, what action do you want to perform
                val intentToOpenNewsDetailActivity= Intent(applicationContext, NewsDetailActivity::class.java)
                intentToOpenNewsDetailActivity.putExtra("heading", newsArrayList[position].newsHeading)
                intentToOpenNewsDetailActivity.putExtra("content", newsArrayList[position].newsContent)
                intentToOpenNewsDetailActivity.putExtra("image", newsArrayList[position].newsImage)
                startActivity(intentToOpenNewsDetailActivity)

            }
        })


        //Working on the Camera Button is here.
        binding.imageViewForCamera.setOnClickListener {
            Toast.makeText(this, "Camera is here", Toast.LENGTH_SHORT).show()

            //This line of Code is used to Open phone Photo Application.
            startActivity(Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI))

        }

        //Working on the Search Button is here.
        binding.imageViewSearch.setOnClickListener {
            Toast.makeText(this, "Search is here", Toast.LENGTH_SHORT).show()
        }

        //Working on the Menu Button is here.
        binding.imageViewForMenu.setOnClickListener {
            Toast.makeText(this, "Menu Button is here", Toast.LENGTH_SHORT).show()
        }

        //Working on the Status Activity
        binding.textViewForStatus.setOnClickListener {
            Toast.makeText(this, "Clicked on status", Toast.LENGTH_SHORT).show()
        }

        //Working on the Calls Activity.
        binding.textViewForCalls.setOnClickListener {
            Toast.makeText(this, "Clicked on Calls", Toast.LENGTH_SHORT).show()
        }

        //Working on the Chat Activity
        binding.textViewForChat.setOnClickListener {
            Toast.makeText(this, "Clicked on Chat", Toast.LENGTH_SHORT).show()
        }

    }
}