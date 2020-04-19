package com.dimchel.feature_competitions.presentation

//@InjectViewState
//class CompetitionPresenter:
//        MvpPresenter<CompetitionsView>(),
//        SingleObserver<List<com.dimchel.feature_competitions.repositories.models.CompetitionModel>> {
//
//    @Inject
//    lateinit var repo: com.dimchel.feature_competitions.repositories.CompetitionRepository
//
//    private var repoDisposable: Disposable? = null
//
//    init {
//        Application.instance.initCompetitionComponent().inject(this)
//    }
//
//    override fun attachView(view: CompetitionsView?) {
//        super.attachView(view)
//
//        repo.getCompetitionsList().subscribe(this)
//    }
//
//    override fun onDestroy() {
//        repoDisposable?.dispose()
//
//        super.onDestroy()
//    }
//
//    // ===========================================================
//    // CompetitionPresenter
//    // ===========================================================
//
//    fun onCompetitionSelected(competitionModel: com.dimchel.feature_competitions.repositories.models.CompetitionModel) {
//        viewState.showLeagueView(competitionModel.id)
//    }
//
//    // ===========================================================
//    // SingleObserver
//    // ===========================================================
//
//    override fun onSuccess(data: List<com.dimchel.feature_competitions.repositories.models.CompetitionModel>) {
//        viewState.showCompetitionsList(data)
//    }
//
//    override fun onError(e: Throwable) {
//
//    }
//
//    override fun onSubscribe(d: Disposable) {
//        this.repoDisposable = d
//    }
//}