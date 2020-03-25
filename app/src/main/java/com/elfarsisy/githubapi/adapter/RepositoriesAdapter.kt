package com.elfarsisy.githubapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.elfarsisy.githubapi.databinding.ItemRepoDetailBinding
import com.elfarsisy.githubapi.model.Repository

class RepositoriesAdapter(val onClickListner: OnClickListener) :
    ListAdapter<Repository, RepositoriesAdapter.RepoViewHolder>(DiffCallBack) {


    class RepoViewHolder(private val binding: ItemRepoDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(repository: Repository) {
            binding.repositories = repository
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        return RepoViewHolder(ItemRepoDetailBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val repositories = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListner.onClick(repositories)
        }
        holder.bind(repositories)
    }

    class OnClickListener(val clickListener: (repositories: Repository) -> Unit) {
        fun onClick(repositories: Repository) = clickListener(repositories)
    }


    companion object DiffCallBack : DiffUtil.ItemCallback<Repository>() {
        override fun areItemsTheSame(oldItem: Repository, newItem: Repository) = oldItem === newItem
        override fun areContentsTheSame(oldItem: Repository, newItem: Repository) = oldItem.id == newItem.id
    }
}


