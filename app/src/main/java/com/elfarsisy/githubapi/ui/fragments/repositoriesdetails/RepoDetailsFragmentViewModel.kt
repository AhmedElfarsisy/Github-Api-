package com.elfarsisy.githubapi.ui.fragments.repositoriesdetails

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.elfarsisy.githubapi.model.Repository

class RepoDetailsFragmentViewModel(repository: Repository, application: Application) :
    AndroidViewModel(application) {
    private val _selectedRepository = MutableLiveData<Repository>()
    val selectedRepository: LiveData<Repository>
        get() = _selectedRepository

    init {
        _selectedRepository.value = repository

    }

    val displayStartCount = Transformations.map(selectedRepository) {
        it.stargazers_count.toString()
    }
    val displayForkCount = Transformations.map(selectedRepository) {
        it.forks_count.toString()
    }
    val displayWatchersCount = Transformations.map(selectedRepository) {
        it.watchers_count.toString()
    }
}