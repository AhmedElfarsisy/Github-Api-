package com.elfarsisy.githubapi.ui.fragments.repositories

import android.os.Bundle
import android.text.Layout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.elfarsisy.githubapi.R
import com.elfarsisy.githubapi.adapter.RepositoriesAdapter
import com.elfarsisy.githubapi.databinding.FragmentProjectsBinding
import com.elfarsisy.githubapi.ui.fragments.repositoriesdetails.RepoDetailsFragmentDirections

class projectsFragment : Fragment() {
    private lateinit var binding: FragmentProjectsBinding
    private lateinit var viewModel: ProjectsFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_projects, container, false)
        viewModel = ViewModelProvider(this).get(ProjectsFragmentViewModel::class.java)


        binding.projectsViewModel = viewModel
        binding.setLifecycleOwner(this)

        binding.recyclerView.adapter = RepositoriesAdapter(RepositoriesAdapter.OnClickListener {
            viewModel.goToRepositoryDetails(it)

        })
        viewModel.navigateToProjectsDetails.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                this.findNavController().navigate(
                    projectsFragmentDirections.actionProjectsFragmentToRepoDetailsFragment(it)
                )
                viewModel.goToRepositoryDetailsComplete()
            }
        })
        return binding.root
    }


}
