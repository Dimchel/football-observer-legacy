package com.dimchel.feature_league.presentation

import com.dimchel.core_architecture.fragments.BaseFragment
import com.dimchel.feature_league.R

class TestFragment : BaseFragment() {

    override fun getLayoutResId(): Int = R.layout.fragment_test

    override fun injectDependencies() = Unit
}