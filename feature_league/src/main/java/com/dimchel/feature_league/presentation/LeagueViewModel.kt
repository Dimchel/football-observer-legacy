package com.dimchel.feature_league.presentation

import androidx.lifecycle.ViewModel
import com.dimchel.feature_competitions_api.data.repositories.CompetitionRepository

class LeagueViewModel(
    private val repo: CompetitionRepository,
) : ViewModel() {

//    init {
//        Application.instance.initCompetitionComponent().inject(this)
//    }
//
//    override fun onFirstViewAttach() {
//        super.onFirstViewAttach()
//
//        viewState.hideStandingList()
//    }
//
//    override fun attachView(view: LeagueView?) {
//        super.attachView(view)
//
//        repo.getLeagueTable(competitionId).subscribe(this)
//    }
//
//    override fun onDestroy() {
//        disposable?.dispose()
//
//        super.onDestroy()
//    }
//
//    // ===========================================================
//    // SingleObserver<LeagueModel>
//    // ===========================================================
//
//    override fun onSuccess(model: com.dimchel.feature_competitions.repositories.models.LeagueModel) {
//        viewState.updateTitleView(model.leagueCaption)
//        viewState.updateMatchdayView(model.matchday)
//
//        viewState.showStandingList(model.standing)
//    }
//
//    override fun onError(t: Throwable) {
//
//    }
//
//    override fun onSubscribe(d: Disposable) {
//        disposable = d
//    }

}