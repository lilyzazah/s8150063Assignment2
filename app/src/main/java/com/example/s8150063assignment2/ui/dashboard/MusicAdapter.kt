package com.example.s8150063assignment2.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.s8150063assignment2.R
import com.example.s8150063assignment2.data.MusicAlbum
import android.widget.ImageView

class MusicAdapter(
    private val albums: List<MusicAlbum>,
    private val onClick: (MusicAlbum) -> Unit
) : RecyclerView.Adapter<MusicAdapter.AlbumViewHolder>() {

    class AlbumViewHolder(view: View)
        : RecyclerView.ViewHolder(view) {

        val albumImage: ImageView =
            view.findViewById(R.id.imgAlbum)

        val artist: TextView =
            view.findViewById(R.id.tvArtist)

        val album: TextView =
            view.findViewById(R.id.tvAlbum)

        val genre: TextView =
            view.findViewById(R.id.tvGenre)

        val trackCount: TextView =
            view.findViewById(R.id.tvTrackCount)

        val popularTrack: TextView =
            view.findViewById(R.id.tvPopularTrack)
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

        when (album.albumTitle) {

            "OK Computer" ->
                holder.albumImage.setImageResource(
                    R.drawable.ok_computer
                )

            "Dummy" ->
                holder.albumImage.setImageResource(
                    R.drawable.dummy
                )

            "Abbey Road" ->
                holder.albumImage.setImageResource(
                    R.drawable.abbey_road
                )

            "Kind of Blue" ->
                holder.albumImage.setImageResource(
                    R.drawable.kind_of_blue
                )

            "Nevermind" ->
                holder.albumImage.setImageResource(
                    R.drawable.nevermind
                )

            "The Dark Side of the Moon" ->
                holder.albumImage.setImageResource(
                    R.drawable.dark_side_of_the_moon
                )

            "To Pimp a Butterfly" ->
                holder.albumImage.setImageResource(
                    R.drawable.to_pimp_a_butterfly
                )
        }

        holder.artist.text = album.artistName
        holder.album.text = album.albumTitle
        holder.genre.text =
            "${album.releaseYear} • ${album.genre}"
        holder.trackCount.text =
            "${album.trackCount} tracks"

        holder.popularTrack.text =
            album.popularTrack
        holder.itemView.setOnClickListener {
            onClick(album)
        }



    }

    override fun getItemCount(): Int {
        return albums.size
    }
}