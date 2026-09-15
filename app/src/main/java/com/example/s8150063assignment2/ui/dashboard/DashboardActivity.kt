package com.example.s8150063assignment2.ui.dashboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.s8150063assignment2.R
import com.example.s8150063assignment2.data.DashboardResponse
import com.example.s8150063assignment2.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.content.Intent
import com.example.s8150063assignment2.ui.details.DetailsActivity
import android.widget.TextView

class DashboardActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_dashboard)

        recyclerView = findViewById(R.id.recyclerViewAlbums)

        recyclerView.layoutManager =
            LinearLayoutManager(this)

        val keypass =
            intent.getStringExtra("KEYPASS") ?: ""

        RetrofitClient.apiService
            .getDashboard(keypass)
            .enqueue(object : Callback<DashboardResponse> {

                override fun onResponse(
                    call: Call<DashboardResponse>,
                    response: Response<DashboardResponse>
                ) {

                    if (response.isSuccessful) {

                        val albums =
                            response.body()?.entities ?: emptyList()

                        findViewById<TextView>(R.id.tvAlbumCount).text =
                            "${albums.size} albums in your collection"


                        recyclerView.adapter = MusicAdapter(albums) { album ->

                            val intent = Intent(
                                this@DashboardActivity,
                                DetailsActivity::class.java
                            )

                            intent.putExtra("artistName", album.artistName)
                            intent.putExtra("albumTitle", album.albumTitle)
                            intent.putExtra("releaseYear", album.releaseYear)
                            intent.putExtra("genre", album.genre)
                            intent.putExtra("trackCount", album.trackCount)
                            intent.putExtra("popularTrack", album.popularTrack)
                            intent.putExtra("description", album.description)

                            startActivity(intent)
                        }
                    }
                }

                override fun onFailure(
                    call: Call<DashboardResponse>,
                    t: Throwable
                ) {

                    t.printStackTrace()
                }
            })
    }
}