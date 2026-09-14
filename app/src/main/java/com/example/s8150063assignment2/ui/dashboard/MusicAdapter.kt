package com.example.s8150063assignment2.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.s8150063assignment2.R
import com.example.s8150063assignment2.data.MusicAlbum

class MusicAdapter(
    private val albums: List<MusicAlbum>,
    private val onClick: (MusicAlbum) -> Unit
) : RecyclerView.Adapter<MusicAdapter.AlbumViewHolder>() {

    class AlbumViewHolder(view: View)
        : RecyclerView.ViewHolder(view) {

        val artist: TextView =
            view.findViewById(R.id.tvArtist)

        val album: TextView =
            view.findViewById(R.id.tvAlbum)

        val genre: TextView =
            view.findViewById(R.id.tvGenre)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AlbumViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.album_item,
                parent,
                false
            )

        return AlbumViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: AlbumViewHolder,
        position: Int

    ) {

        val album = albums[position]

        holder.artist.text = album.artistName
        holder.album.text = album.albumTitle
        holder.genre.text = album.genre
        holder.itemView.setOnClickListener {
            onClick(album)
        }
    }

    override fun getItemCount(): Int {
        return albums.size
    }
}