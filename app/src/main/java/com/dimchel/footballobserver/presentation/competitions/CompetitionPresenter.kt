package com.dimchel.footballobserver.presentation.competitions

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.dimchel.footballobserver.Application
import com.dimchel.footballobserver.data.repos.competition.CompetitionRepository
import com.dimchel.footballobserver.data.repos.competition.models.CompetitionModel
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import javax.inject.Inject


@InjectViewState
class CompetitionPresenter:
        MvpPresenter<CompetitionsView>(),
        SingleObserver<List<CompetitionModel>> {

    @Inject
    lateinit var repo: CompetitionRepository

    private var repoDisposable: Disposable? = null

    init {
        Application.instance.initCompetitionComponent().inject(this)
    }

    override fun attachView(view: CompetitionsView?) {
        super.attachView(view)

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
        viewState.showCompetitionsList(data)
    }

    override fun onError(e: Throwable) {

    }

    override fun onSubscribe(d: Disposable) {
        this.repoDisposable = d
    }
}