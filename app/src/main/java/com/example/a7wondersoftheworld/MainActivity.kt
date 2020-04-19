package com.example.a7wondersoftheworld

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var landmarkNames = ArrayList<String>()
        landmarkNames.add("Great Wall of China")
        landmarkNames.add("Petra")
        landmarkNames.add("Christ the Redeemer")
        landmarkNames.add("Machu Picchu")
        landmarkNames.add("Chichen Itza")
        landmarkNames.add("Colosseum")
        landmarkNames.add("Taj Mahal")

        val great = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.great_wall)
        val petra = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.petra)
        val chirst = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.chirst)
        val machu  = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.machu)
        val chichen = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.chichen)
        val colo = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.colosseum)
        val taj  = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.taj)

        var landmarkImages = ArrayList<Bitmap>()
        landmarkImages.add(great)
        landmarkImages.add(petra)
        landmarkImages.add(chirst)
        landmarkImages.add(machu)
        landmarkImages.add(chichen)
        landmarkImages.add(colo)
        landmarkImages.add(taj)

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,landmarkNames)

        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(applicationContext,DetailActivity::class.java)

            intent.putExtra("name",landmarkNames[position])

            val bitmap = landmarkImages[position]

            val chosen = Globals.Chosen

            chosen.chosenImage = bitmap

            startActivity(intent)
        }

    }
}
