package com.example.s8150063assignment2.ui.details

import android.os.Bundle
import android.widget.ImageView
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


        val tvAlbumTitle =
            findViewById<TextView>(R.id.tvAlbumTitle)

        val tvArtistName =
            findViewById<TextView>(R.id.tvArtistName)

        val tvAlbumInfo =
            findViewById<TextView>(R.id.tvAlbumInfo)

        val tvPopularTrack =
            findViewById<TextView>(R.id.tvPopularTrack)

        val tvDescription =
            findViewById<TextView>(R.id.tvDescription)

        val tvTrackList =
            findViewById<TextView>(R.id.tvTrackList)

        val imgAlbumCover =
            findViewById<ImageView>(R.id.imgAlbumCover)



        tvAlbumTitle.text = albumTitle

        tvArtistName.text = artistName

        tvAlbumInfo.text =
            "$releaseYear • $genre • $trackCount tracks"

        tvPopularTrack.text = popularTrack

        tvDescription.text = description

        tvTrackList.text =
            getTrackList(albumTitle ?: "")



        when (albumTitle) {

            "OK Computer" -> {

                imgAlbumCover.setImageResource(
                    R.drawable.ok_computer
                )

            }

            "Dummy" -> {

                imgAlbumCover.setImageResource(
                    R.drawable.dummy
                )


            }

            "Abbey Road" -> {

                imgAlbumCover.setImageResource(
                    R.drawable.abbey_road
                )


            }

            "Kind of Blue" -> {

                imgAlbumCover.setImageResource(
                    R.drawable.kind_of_blue
                )

            }

            "Nevermind" -> {

                imgAlbumCover.setImageResource(
                    R.drawable.nevermind
                )

            }

            "The Dark Side of the Moon" -> {

                imgAlbumCover.setImageResource(
                    R.drawable.dark_side_of_the_moon
                )


            }

            "To Pimp a Butterfly" -> {

                imgAlbumCover.setImageResource(
                    R.drawable.to_pimp_a_butterfly
                )


            }
        }


    }

    private fun getTrackList(
        albumTitle: String
    ): String {

        return when (albumTitle) {

            "OK Computer" ->
                """
1. Airbag
2. Paranoid Android
3. Subterranean Homesick Alien
4. Exit Music (For A Film)
5. Let Down
            """.trimIndent()

            "Dummy" ->
                """
1. Mysterons
2. Sour Times
3. Strangers
4. It Could Be Sweet
5. Wandering Star
            """.trimIndent()

            "Abbey Road" ->
                """
1. Come Together
2. Something
3. Maxwell's Silver Hammer
4. Oh! Darling
5. Octopus's Garden
            """.trimIndent()

            "Kind of Blue" ->
                """
1. So What
2. Freddie Freeloader
3. Blue in Green
4. All Blues
5. Flamenco Sketches
            """.trimIndent()

            "Nevermind" ->
                """
1. Smells Like Teen Spirit
2. In Bloom
3. Come As You Are
4. Breed
5. Lithium
            """.trimIndent()

            "The Dark Side of the Moon" ->
                """
1. Speak to Me
2. Breathe
3. On the Run
4. Time
5. The Great Gig in the Sky
            """.trimIndent()

            else ->
                "Track list unavailable"
        }
    }
}