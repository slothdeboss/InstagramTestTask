package com.slothdeboss.instagramtesttask.presentation.ui.adapter

import android.text.Html
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.slothdeboss.instagramtesttask.R
import com.slothdeboss.instagramtesttask.domain.entity.Post
import com.slothdeboss.instagramtesttask.presentation.util.loadImage
import kotlinx.android.synthetic.main.post_card.view.*

class PostsAdapter: RecyclerView.Adapter<PostsViewHolder>() {

    private val posts: MutableList<Post> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.post_card, parent, false
        )
        return PostsViewHolder(view = view)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val post = posts[position]
        holder.bind(post = post)
    }

    fun loadPosts(newPosts: List<Post>) {
        posts.clear()
        posts.addAll(newPosts)
        notifyDataSetChanged()
    }
}

class PostsViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

    fun bind(post: Post) {
        view.apply {
            cardProfilePhoto.loadImage(post.imageUrl)
            postCardPhoto.loadImage(post.imageUrl)
            profileUserName.text = post.username
            cardLocation.text = post.location
            likesSection.text = getLikesSection(likes = post.likes)
            postCardDescription.text = getDescriptionSection(
                username = post.username, description = post.description
            )
        }
    }

    private fun getLikesSection(likes: List<String>): Spanned {
        val likesString = likes.take(2).joinToString(", ")
        val countHiddenLikes = likes.size - 1
        return Html.fromHtml("Liked by <b>$likesString</b> and <b>$countHiddenLikes others</b>")
    }


    private fun getDescriptionSection(username: String, description: String): Spanned {
        return Html.fromHtml("<b>$username</b> $description")
    }
}
