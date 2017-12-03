package com.dimchel.footballobserver.presentation.competitions

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.dimchel.footballobserver.data.networks.models.responses.CompetitionScheme


@StateStrategyType(AddToEndSingleStrategy::class)
interface CompetitionsView: MvpView{

    fun showCompetitionsList(competitionsList: List<CompetitionScheme>)

}