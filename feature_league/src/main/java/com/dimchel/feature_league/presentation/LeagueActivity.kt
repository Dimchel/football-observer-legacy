package com.dimchel.feature_league.presentation

//
//class LeagueActivity : MvpAppCompatActivity(), LeagueView, SimpleOnItemSelectedListener<com.dimchel.feature_competitions.repositories.models.CompetitionerModel> {
//
//    companion object {
//        val BUNDLE_COMPETITION_ID = "CompetitionsActivity.BUNDLE_COMPETITION_ID"
//    }
//
//    private lateinit var leagueRecyclerView: RecyclerView
//    private lateinit var adapter: LeagueRvAdapter
//
//    @InjectPresenter
//    lateinit var presenter: LeaguePresenter
//
//    @ProvidePresenter
//    fun provideLeaguePresenter(): LeaguePresenter {
//        return LeaguePresenter(intent.getLongExtra(
//            BUNDLE_COMPETITION_ID, 0))
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        setContentView(R.layout.activity_league)
//
//        initActionBar()
//
//        initViews()
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//        return when (item?.itemId) {
//            android.R.id.home -> {
//                finish()
//
//                return true
//            }
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
//
//    private fun initActionBar() {
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//    }
//
//    private fun initViews() {
//        initRecycler()
//    }
//
//    private fun initRecycler() {
//        leagueRecyclerView = league_league_recyclerview
//
//        leagueRecyclerView.layoutManager = LinearLayoutManager(this)
//
//        val decorator = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
//        leagueRecyclerView.addItemDecoration(decorator)
//
//        adapter = LeagueRvAdapter(IconManager(),this)
//        leagueRecyclerView.adapter = adapter
//    }
//
//    // ===========================================================
//    // LeagueView
//    // ===========================================================
//
//    override fun updateTitleView(leagueName: String) {
//        supportActionBar?.title = leagueName
//    }
//
//    override fun updateMatchdayView(matchday: Int) {
//
//    }
//
//    override fun showStandingList(competitionersList: List<com.dimchel.feature_competitions.repositories.models.CompetitionerModel>) {
//        adapter.setData(competitionersList)
//
//        leagueRecyclerView.visibility = View.VISIBLE
//    }
//
//    override fun hideStandingList() {
//        leagueRecyclerView.visibility = View.INVISIBLE
//    }
//
//    // ===========================================================
//    // SimpleOnItemSelectedListener
//    // ===========================================================
//
//    override fun onItemSelected(item: com.dimchel.feature_competitions.repositories.models.CompetitionerModel) {
//
//    }
//
//}