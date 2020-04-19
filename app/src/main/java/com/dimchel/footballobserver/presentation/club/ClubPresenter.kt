package com.dimchel.footballobserver.presentation.club


//@InjectViewState
//class ClubPresenter(private val clubId: Long) : MvpPresenter<ClubView>() {
//
//    private var disposable: Disposable? = null
//
//    @Inject
//    lateinit var repo: com.dimchel.feature_competitions.repositories.CompetitionRepository
//
//    init {
////        Application.instance.initClubComponent().inject(this)
//    }
//
//    override fun onFirstViewAttach() {
//        super.onFirstViewAttach()
//    }
//
//    override fun attachView(view: ClubView?) {
//        super.attachView(view)
//
////        repo.getLeagueTable(competitionId).subscribe(this)
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
////    override fun onSuccess(model: LeagueModel) {
////        viewState.updateTitleView(model.leagueCaption)
////        viewState.updateMatchdayView(model.matchday)
////
////        viewState.showStandingList(model.standing)
////    }
////
////    override fun onError(t: Throwable) {
////
////    }
////
////    override fun onSubscribe(d: Disposable) {
////        disposable = d
////    }
//
//}