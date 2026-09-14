package com.example.s8150063assignment2.ui.details

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.s8150063assignment2.R

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_details)

        val artistName = intent.getStringExtra("artistName")
        val albumTitle = intent.getStringExtra("albumTitle")
        val releaseYear = intent.getIntExtra("releaseYear", 0)
        val genre = intent.getStringExtra("genre")
        val trackCount = intent.getIntExtra("trackCount", 0)
        val popularTrack = intent.getStringExtra("popularTrack")
        val description = intent.getStringExtra("description")

        val tvDetails =
            findViewById<TextView>(R.id.tvDetails)

        tvDetails.text =
            """
Artist: $artistName

Album: $albumTitle

Release Year: $releaseYear

Genre: $genre

Tracks: $trackCount

Popular Track: $popularTrack

Description:
$description
            """.trimIndent()
    }
}