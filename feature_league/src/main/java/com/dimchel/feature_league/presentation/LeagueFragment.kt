package com.dimchel.feature_league.presentation

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dimchel.core_architecture.data.ProgressData
import com.dimchel.core_architecture.fragments.BaseFragment
import com.dimchel.core_architecture.fragments.viewBinding
import com.dimchel.core_architecture.viewmodels.ViewModelFactory
import com.dimchel.core_architecture.viewmodels.getViewModel
import com.dimchel.feature_league.R
import com.dimchel.feature_league.databinding.FragmentLeagueBinding
import com.dimchel.feature_league.di.LeagueComponent
import com.dimchel.feature_league.di.LeagueDependencyProviderImpl
import com.dimchel.feature_league.presentation.list.LeagueAdapter
import javax.inject.Inject

class LeagueFragment : BaseFragment() {

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory<LeagueViewModel>
    private lateinit var viewModel: LeagueViewModel

    private val binding by viewBinding(FragmentLeagueBinding::bind)

    private lateinit var adapter: LeagueAdapter

    override fun getLayoutResId(): Int = R.layout.fragment_league
    override fun injectDependencies() {
        (LeagueDependencyProviderImpl.provide(requireActivity().application) as LeagueComponent)
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()

        initViewModel()
    }

    private fun initViews() {
        initRecycler()

        binding.leagueRetryButton.setOnClickListener {
            viewModel.onRetryAction()
        }
    }

    private fun initRecycler() {
        binding.leagueRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())

            addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))

            this@LeagueFragment.adapter = LeagueAdapter { }
            adapter = this@LeagueFragment.adapter
        }
    }

    private fun initViewModel() {
        viewModel = viewModelFactory.getViewModel(this)

        viewModel.onReceiveParams(requireArguments().getString("leagueCode")!!)

        viewModel.leagueLiveData.observe(viewLifecycleOwner) {
            binding.apply {
                leagueRecyclerView.isVisible = false
                leagueProgressBar.isVisible = false
                leagueRetryButton.isVisible = false

                when (it) {
                    is ProgressData.Loading -> leagueProgressBar.isVisible = true
                    is ProgressData.Error -> leagueRetryButton.isVisible = true
                    is ProgressData.Success -> {
                        adapter.setData(it.result)

                        leagueRecyclerView.isVisible = true
                    }
                }
            }
        }
    }
}