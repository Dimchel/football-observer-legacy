package com.dimchel.footballobserver.presentation.league

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.dimchel.footballobserver.data.repos.competition.CompetitionRepo
import com.dimchel.footballobserver.data.repos.competition.models.LeagueModel
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable


@InjectViewState
class LeaguePresenter(private val competitionId: Long, private val repo: CompetitionRepo):
        MvpPresenter<LeagueView>(),
        SingleObserver<LeagueModel> {

    private var disposable: Disposable? = null


    override fun attachView(view: LeagueView?) {
        super.attachView(view)

        viewState.showStandingListView(false)
        viewState.showProgressView(true)

        repo.getLeagueTable(competitionId).subscribe(this)
    }

    override fun onDestroy() {
        disposable?.dispose()

        super.onDestroy()
    }

    // ===========================================================
    // SingleObserver<LeagueModel>
    // ===========================================================

    override fun onSuccess(model: LeagueModel) {
        viewState.updateTitleView(model.leagueCaption)
        viewState.updateMatchdayView(model.matchday)

        viewState.showProgressView(false)
        viewState.showStandingListView(true)

        viewState.updateStandingListView(model.standing)
    }

    override fun onError(t: Throwable) {

    }

    override fun onSubscribe(d: Disposable) {
        disposable = d
    }

}