package com.dimchel.feature_competitions.presentation

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dimchel.core_architecture.fragments.BaseFragment
import com.dimchel.core_architecture.fragments.viewBinding
import com.dimchel.core_architecture.viewmodels.ViewModelFactory
import com.dimchel.core_architecture.viewmodels.getViewModel
import com.dimchel.feature_competitions.R
import com.dimchel.feature_competitions.databinding.CompetitionsActivityBinding
import com.dimchel.feature_competitions.di.CompetitionComponent
import com.dimchel.feature_competitions.di.CompetitionDependencyProviderImpl
import javax.inject.Inject

class CompetitionsFragment : BaseFragment() {

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory<CompetitionViewModel>
    private lateinit var viewModel: CompetitionViewModel

    private lateinit var adapter: CompetitionsAdapter

    private val binding by viewBinding(CompetitionsActivityBinding::bind)

    override fun getLayoutResId(): Int = R.layout.competitions_activity
    override fun injectDependencies() {
        (CompetitionDependencyProviderImpl.provide(requireActivity().application) as CompetitionComponent)
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()

        viewModel = viewModelFactory.getViewModel(this)
        viewModel.competitionsLiveData.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }

    private fun initViews() {
        initRecycler()
    }

    private fun initRecycler() {
        binding.competitionsRecyclerview.apply {
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))

            this@CompetitionsFragment.adapter = CompetitionsAdapter { }
            adapter = this@CompetitionsFragment.adapter
        }
    }
}