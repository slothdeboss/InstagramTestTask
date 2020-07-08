package com.slothdeboss.instagramtesttask.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.slothdeboss.instagramtesttask.R
import com.slothdeboss.instagramtesttask.presentation.ui.adapter.PostsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: PostViewModel by viewModels()
    private lateinit var postsAdapter: PostsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        postsAdapter = PostsAdapter()
        setupPostList()
    }

    override fun onStart() {
        super.onStart()
        viewModel.fetchPosts("dummy_data.json")
        observePosts()
    }

    private fun observePosts() {
        viewModel.posts.observe(this) { posts ->
            Log.i("Activity", posts.size.toString())
            postsAdapter.loadPosts(newPosts = posts)
        }
    }

    private fun setupPostList() {
        postsList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postsAdapter
        }
    }

    fun profilePhotoClick(view: View) {
        displayMessage(message = "Profile photo clicked!")
    }

    fun shareButtonClick(view: View) {
        displayMessage(message = "Share clicked!")
    }

    fun saveButtonClick(view: View) {
        displayMessage(message = "Save clicked!")
    }

    fun moreButtonClick(view: View) {
        displayMessage(message = "More clicked!")
    }

    fun commentButtonClick(view: View) {
        displayMessage(message = "Comment clicked!")
    }

    fun likeButtonClick(view: View) {
        displayMessage(message = "Like clicked!")
    }

    fun profileNameClick(view: View) {
        displayMessage(message = "Profile clicked!")
    }

    fun locationClick(view: View) {
        displayMessage(message = "Location clicked!")
    }

    fun likesClick(view: View) {
        displayMessage(message = "Likes clicked!")
    }

    private fun displayMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}