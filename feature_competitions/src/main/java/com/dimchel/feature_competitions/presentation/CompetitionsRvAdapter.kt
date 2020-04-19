package com.dimchel.feature_competitions.presentation

//class CompetitionsRvAdapter(private val listener: SimpleOnItemSelectedListener<com.dimchel.feature_competitions.repositories.models.CompetitionModel>) : RecyclerView.Adapter<CompetitionsRvAdapter.ViewHolder>() {
//
//    private var competitionsList: List<com.dimchel.feature_competitions.repositories.models.CompetitionModel> = ArrayList()
//
//    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_competition, parent, false)
//
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
//
//        val context = holder!!.itemView.context
//
//        with(competitionsList[position]) {
//
//            holder.nameTextView.text = let { caption }
//            holder.matchdayTextView.text = let { currentMatchday.toString() }
//            holder.teamTextView.text = let { numberOfTeams.toString() }
//            holder.updatedTextView.text = let { lastUpdated }
//
//            holder.itemView.setOnClickListener {
//             listener.onItemSelected(let { this })
//            }
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return competitionsList.size
//    }
//
//    fun setData(competitionsList: List<com.dimchel.feature_competitions.repositories.models.CompetitionModel>) {
//        this.competitionsList = competitionsList
//
//        this.notifyDataSetChanged()
//    }
//
//    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val nameTextView = itemView.item_competition_name_textview
//        val updatedTextView = itemView.item_competition_updated_textview
//        val teamTextView = itemView.item_competition_teams_textview
//        val matchdayTextView = itemView.item_competition_matchday_textview
//    }
//
//}