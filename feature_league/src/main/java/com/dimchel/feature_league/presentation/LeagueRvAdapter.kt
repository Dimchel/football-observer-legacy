package com.dimchel.feature_league.presentation

//class LeagueRvAdapter(
//        private val iconManager: IconManager,
//        private val listener: SimpleOnItemSelectedListener<com.dimchel.feature_competitions.repositories.models.CompetitionerModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//
//    companion object {
//        val ITEM_HEADER: Int = 0
//        val ITEM_COMPETITIONER: Int = 1
//
//        val WINNER_POSITION = 0 + 1
//        val CHAMPIONS_LEAGUE_MIN_POSITION = 3 + 1
//        val EUROPE_CUP_MIN_POSITION = 4 + 1
//        val LOSS_MIN_POSITION = 17 + 1
//    }
//
//    private var competitionersList: List<com.dimchel.feature_competitions.repositories.models.CompetitionerModel> = ArrayList()
//
//    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
//        val view: View
//
//        return if (viewType == ITEM_HEADER) {
//            view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_league_header, parent, false)
//
//	        HeaderViewHolder(view)
//        } else {
//            view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_league, parent, false)
//
//	        ViewHolder(view)
//        }
//    }
//
//    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder?, position: Int) {
//        if (getItemViewType(position) == ITEM_COMPETITIONER) {
//            val holder = viewHolder as ViewHolder
//
//            val context = holder.itemView.context
//
//            with(competitionersList[position - 1]) {
//
//                holder.iconImageView.setImageResource(iconManager.getImageResource(let { teamName }))
//
//                holder.nameTextView.text = let { teamName }
//                holder.positionTextView.text = (position).toString()
//                holder.playsTextView.text = let { playedGames.toString() }
//                holder.winsTextView.text = let { wins.toString() }
//                holder.drawsTextView.text = let { draws.toString() }
//                holder.loosesTextView.text = let { losses.toString() }
//                holder.goalDifferenceTextView.text = let { goalDifference.toString() }
//                holder.pointsTextView.text = let { points.toString() }
//
//                when {
//                    position == WINNER_POSITION -> {
//                        holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.color_club_winner))
//                    }
//                    position <= CHAMPIONS_LEAGUE_MIN_POSITION -> {
//                        holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.color_club_cl))
//                    }
//                    position <= EUROPE_CUP_MIN_POSITION -> {
//                        holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.color_club_ec))
//                    }
//                    position >= LOSS_MIN_POSITION -> {
//                        holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.color_club_winner))
//                    }
//                    else -> holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.color_background))
//                }
//
//                holder.clickableLayout.setOnClickListener {
//                    listener.onItemSelected(let { this })
//                }
//            }
//        }
//    }
//
//    override fun getItemViewType(position: Int): Int {
//        return if (position == 0) {
//	        ITEM_HEADER
//        } else{
//	        ITEM_COMPETITIONER
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return competitionersList.size + 1
//    }
//
//    fun setData(competitionersList: List<com.dimchel.feature_competitions.repositories.models.CompetitionerModel>) {
//        this.competitionersList = competitionersList
//
//        this.notifyDataSetChanged()
//    }
//
//    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//        val nameTextView = itemView.item_competitioner_name_textview!!
//        val iconImageView = itemView.item_competitioner_icon_imageview!!
//        val positionTextView = itemView.item_competitioner_pos_textview!!
//        val playsTextView = itemView.item_competitioner_p_textview!!
//        val winsTextView = itemView.item_competitioner_w_textview!!
//        val drawsTextView = itemView.item_competitioner_d_textview!!
//        val loosesTextView = itemView.item_competitioner_l_textview!!
//        val goalDifferenceTextView = itemView.item_competitioner_gd_textview!!
//        val pointsTextView = itemView.item_competitioner_pts_textview!!
//        val clickableLayout = itemView.item_competitioner_clickable_layout!!
//    }
//
//    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
//
//}