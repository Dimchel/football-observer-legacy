package com.dimchel.feature_league.presentation

//@InjectViewState
//class LeaguePresenter(private val competitionId: Long) :
//        MvpPresenter<LeagueView>(),
//        SingleObserver<com.dimchel.feature_competitions.repositories.models.LeagueModel> {
//
//    private var disposable: Disposable? = null
//
//    @Inject
//    lateinit var repo: com.dimchel.feature_competitions.repositories.CompetitionRepository
//
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
//
//}