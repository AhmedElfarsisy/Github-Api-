package com.elfarsisy.githubapi.ui.fragments.repositoriesdetails

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.elfarsisy.githubapi.model.Repository

class RepoDetailsViewModelFactory(private val repository: Repository, private val application: Application) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RepoDetailsFragmentViewModel::class.java)) {
            return RepoDetailsFragmentViewModel(repository, application ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}