package com.dimchel.footballobserver.presentation.competitions

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.dimchel.footballobserver.Application
import com.dimchel.footballobserver.data.networks.NetworkError
import com.dimchel.footballobserver.data.networks.models.responses.CompetitionScheme
import com.dimchel.footballobserver.data.repos.OnRepoDataListener
import com.dimchel.footballobserver.data.repos.competitions.CompetitionsRepo
import javax.inject.Inject


@InjectViewState
class CompetitionPresenter: MvpPresenter<CompetitionsView>(), OnRepoDataListener<List<CompetitionScheme>> {

    @Inject
    lateinit var repo: CompetitionsRepo

    init {
        Application.instance.initCompetitionComponent().inject(this)

        repo.getCompetitionsList(this)
    }

    override fun onDestroy() {
        Application.instance.destroyCompetitionComponent()

        super.onDestroy()
    }

    // ===========================================================
    // CompetitionPresenter
    // ===========================================================

    fun onCompetitionSelected(competitionScheme: CompetitionScheme) {

    }

    // ===========================================================
    // OnRepoDataListener
    // ===========================================================

    override fun onResult(result: List<CompetitionScheme>) {
        viewState.showCompetitionsList(result)
    }

    override fun onFailure(error: NetworkError) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}