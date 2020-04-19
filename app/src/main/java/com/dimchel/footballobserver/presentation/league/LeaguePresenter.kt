package com.dimchel.footballobserver.presentation.league

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.dimchel.footballobserver.Application
import com.dimchel.footballobserver.data.repos.competition.CompetitionRepository
import com.dimchel.footballobserver.data.repos.competition.models.LeagueModel
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import javax.inject.Inject


@InjectViewState
class LeaguePresenter(private val competitionId: Long) :
        MvpPresenter<LeagueView>(),
        SingleObserver<LeagueModel> {

    private var disposable: Disposable? = null

    @Inject
    lateinit var repo: CompetitionRepository

    init {
        Application.instance.initCompetitionComponent().inject(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.hideStandingList()
    }

    override fun attachView(view: LeagueView?) {
        super.attachView(view)

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

        viewState.showStandingList(model.standing)
    }

    override fun onError(t: Throwable) {

    }

    override fun onSubscribe(d: Disposable) {
        disposable = d
    }

}