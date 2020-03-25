package com.elfarsisy.githubapi

import android.media.Image
import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.elfarsisy.githubapi.adapter.RepositoriesAdapter
import com.elfarsisy.githubapi.model.Repository
import com.elfarsisy.githubapi.ui.fragments.repositories.ApiStatus
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_projects.*

//Glid photo
@BindingAdapter("avatar_url")
fun bindRepoOwnerPhoto(ownerImageView: ImageView, avatar_url: String?) {
    avatar_url?.let {
        val imageUri = Uri.parse(avatar_url).buildUpon().scheme("https").build()
        Glide.with(ownerImageView.context).load(imageUri)
            .apply(RequestOptions().placeholder(R.drawable.loading_animation).error(R.drawable.ic_broken_image_black_24dp))
            .into(ownerImageView)
    }
}

@BindingAdapter("ApiStatus")
fun bindStatus(statusProgressBar: ProgressBar, status: ApiStatus?) {
    when (status) {
        ApiStatus.LOADING -> {
            statusProgressBar.visibility = View.VISIBLE
        }
        ApiStatus.ERROR -> {
            statusProgressBar.visibility = View.GONE
        }
        ApiStatus.DONE -> {
            statusProgressBar.visibility = View.GONE
        }
    }
}

@BindingAdapter("dataList")
fun bindRecyclerView(recyclerView: RecyclerView, dataList: List<Repository>?) {
    val adapter = recyclerView.adapter as RepositoriesAdapter
    adapter.submitList(dataList)

}


@BindingAdapter("NetworkError")
fun bindNetworkFaliure(networkImageView: ImageView, status: ApiStatus?) {
    when (status) {
        ApiStatus.LOADING -> {
            networkImageView.visibility = View.GONE
        }
        ApiStatus.ERROR -> {
            networkImageView.visibility = View.VISIBLE
            networkImageView.setImageResource(R.drawable.ic_cloud_off_black_24dp)
        }
        ApiStatus.DONE -> {
            networkImageView.visibility = View.GONE
        }
    }
}




