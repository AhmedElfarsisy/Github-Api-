package com.elfarsisy.githubapi.ui.fragments.repositories


import androidx.lifecycle.*
import com.elfarsisy.githubapi.model.Repository
import com.elfarsisy.githubapi.network.repositoriesApi
import kotlinx.coroutines.*


enum class ApiStatus { LOADING, ERROR, DONE }
class ProjectsFragmentViewModel() : ViewModel() {
    val viewModelJob = Job()
    val uiScope = CoroutineScope(viewModelJob + Dispatchers.Main)


    private val _status = MutableLiveData<ApiStatus>()
    val status: LiveData<ApiStatus>
        get() = _status

    private val _navigateToProjectsDetails = MutableLiveData<Repository>()
    val navigateToProjectsDetails: LiveData<Repository>
        get() = _navigateToProjectsDetails

    private var _reposetiories = MutableLiveData<List<Repository>>()
    val repositories: LiveData<List<Repository>>
        get() = _reposetiories




    init {
        getRepositories(1, 15)
    }


    private fun getRepositories(page: Int, per_page: Int) {
        uiScope.launch {
            var getReposDeferred = repositoriesApi.retrofitServices.getRepositories(page, per_page)
            try {
                _status.value = ApiStatus.LOADING
                val listResult = getReposDeferred.await()
                _status.value = ApiStatus.DONE

                _reposetiories.value = listResult
            } catch (e: Exception) {
                _status.value = ApiStatus.ERROR
                _reposetiories.value=ArrayList()
            }
        }
    }


    fun goToRepositoryDetails(repository: Repository) {
        _navigateToProjectsDetails.value = repository
    }

    fun goToRepositoryDetailsComplete() {
        _navigateToProjectsDetails.value = null
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }


}


