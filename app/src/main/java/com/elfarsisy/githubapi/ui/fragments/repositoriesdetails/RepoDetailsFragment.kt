package com.elfarsisy.githubapi.ui.fragments.repositoriesdetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

import com.elfarsisy.githubapi.R
import com.elfarsisy.githubapi.databinding.FragmentRepoDetailsBinding

/**
 * A simple [Fragment] subclass.
 */
class RepoDetailsFragment : Fragment() {
    private lateinit var binding: FragmentRepoDetailsBinding
    private lateinit var viewModel: RepoDetailsFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_repo_details, container, false)
        val application = requireNotNull(activity).application
        val repository=RepoDetailsFragmentArgs.fromBundle(arguments!!).selectedRepository
        val viewModelFactory = RepoDetailsViewModelFactory(repository, application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(RepoDetailsFragmentViewModel::class.java)

        binding.repoDetailsViewModel = viewModel
        binding.setLifecycleOwner(this)

        return binding.root
    }

}
