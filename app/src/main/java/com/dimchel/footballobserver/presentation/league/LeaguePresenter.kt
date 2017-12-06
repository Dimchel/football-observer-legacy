package com.dimchel.footballobserver.presentation.league

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.dimchel.footballobserver.Application
import com.dimchel.footballobserver.data.repos.competition.CompetitionRepo
import com.dimchel.footballobserver.data.repos.competition.models.LeagueModel
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import javax.inject.Inject


@InjectViewState
class LeaguePresenter(competitionId: Long) :
        MvpPresenter<LeagueView>(),
        SingleObserver<LeagueModel> {

    private var disposable: Disposable? = null

    @Inject
    lateinit var repo: CompetitionRepo

    init {
        Application.instance.initCompetitionComponent().inject(this)

        repo.getLeagueTable(competitionId).subscribe(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.hideStandingList()
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

        viewState.showStandingList(model.standing)
    }

    override fun onError(t: Throwable) {

    }

    override fun onSubscribe(d: Disposable) {
        disposable = d
    }

}