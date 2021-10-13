package com.dimchel.feature_competitions.presentation

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dimchel.core_architecture.data.ProgressData
import com.dimchel.core_architecture.fragments.BaseFragment
import com.dimchel.core_architecture.fragments.viewBinding
import com.dimchel.core_architecture.viewmodels.ViewModelFactory
import com.dimchel.core_architecture.viewmodels.getViewModel
import com.dimchel.feature_competitions.R
import com.dimchel.feature_competitions.databinding.FragmentCompetitionsBinding
import com.dimchel.feature_competitions.di.CompetitionComponent
import com.dimchel.feature_competitions.di.CompetitionDependencyProviderImpl
import javax.inject.Inject

class CompetitionsFragment : BaseFragment() {

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory<CompetitionViewModel>
    private lateinit var viewModel: CompetitionViewModel

    private lateinit var adapter: CompetitionsAdapter

    private val binding by viewBinding(FragmentCompetitionsBinding::bind)

    override fun getLayoutResId(): Int = R.layout.fragment_competitions
    override fun injectDependencies() {
        (CompetitionDependencyProviderImpl.provide(requireActivity().application) as CompetitionComponent)
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()

        initViewModel()
    }

    private fun initViews() {
        initRecycler()

        binding.competitionsRetryButton.setOnClickListener {
            viewModel.onRetryAction()
        }
    }

    private fun initRecycler() {
        binding.competitionsRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))

            this@CompetitionsFragment.adapter = CompetitionsAdapter {
                viewModel.onCompetitionSelected(it)

                findNavController().navigate(CompetitionsFragmentDirections.actionToFlowLeague(it.code.toString()))
            }
            adapter = this@CompetitionsFragment.adapter
        }
    }

    private fun initViewModel() {
        viewModel = viewModelFactory.getViewModel(this)

        viewModel.competitionsLiveData.observe(viewLifecycleOwner) {
            binding.apply {
                competitionsRecyclerView.isVisible = false
                competitionsProgressBar.isVisible = false
                competitionsRetryButton.isVisible = false

                when (it) {
                    is ProgressData.Loading -> competitionsProgressBar.isVisible = true
                    is ProgressData.Error -> competitionsRetryButton.isVisible = true
                    is ProgressData.Success -> {
                        adapter.setData(it.result)

                        competitionsRecyclerView.isVisible = true
                    }
                }
            }
        }
    }
}