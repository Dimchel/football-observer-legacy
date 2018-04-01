package com.dimchel.footballobserver.presentation.competitions

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.dimchel.footballobserver.data.repos.competition.CompetitionRepo
import com.dimchel.footballobserver.data.repos.competition.models.CompetitionModel
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable


@InjectViewState
class CompetitionPresenter(private val repo: CompetitionRepo):
        MvpPresenter<CompetitionsView>(),
        SingleObserver<List<CompetitionModel>> {

    private var repoDisposable: Disposable? = null

    override fun attachView(view: CompetitionsView?) {
        super.attachView(view)

        viewState.showCompetitionsListView(false)
        viewState.showProgress(true)

        repo.getCompetitionsList().subscribe(this)
    }

    override fun onDestroy() {
        repoDisposable?.dispose()

        super.onDestroy()
    }

    // ===========================================================
    // CompetitionPresenter
    // ===========================================================

    fun onCompetitionSelected(competitionModel: CompetitionModel) {
        viewState.showLeagueView(competitionModel.id)
    }

    // ===========================================================
    // SingleObserver
    // ===========================================================

    override fun onSuccess(data: List<CompetitionModel>) {
        viewState.showProgress(false)

        viewState.showCompetitionsListView(true)
        viewState.updateCompetitionsListView(data)
    }

    override fun onError(e: Throwable) {

    }

    override fun onSubscribe(d: Disposable) {
        this.repoDisposable = d
    }
}