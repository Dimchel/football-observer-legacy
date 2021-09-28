package com.dimchel.feature_league.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dimchel.feature_competitions_api.data.models.CompetitionerModel
import com.dimchel.feature_league.databinding.ItemLeagueBinding
import com.dimchel.feature_league.presentation.list.LeagueListModel.CompetitionerListModel
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class LeagueDelegate(
    private val listener: (competitionModel: CompetitionerModel) -> Unit
): AbsListItemAdapterDelegate<CompetitionerListModel, LeagueListModel, LeagueViewHolder>() {

    override fun isForViewType(
        item: LeagueListModel,
        items: MutableList<LeagueListModel>,
        position: Int
    ): Boolean = item is CompetitionerListModel

    override fun onCreateViewHolder(parent: ViewGroup) = LeagueViewHolder(
        ItemLeagueBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(
        item: CompetitionerListModel,
        holder: LeagueViewHolder,
        payloads: MutableList<Any>
    ) {
        holder.binding.apply {
//            itemCompetitionerIconImageview.setImageResource(iconManager.getImageResource(let { teamName }))

            itemCompetitionerNameTextview.text = let { item.model.teamName }
            itemCompetitionerPosTextview.text = (holder.adapterPosition).toString()
            itemCompetitionerPTextview.text = let { item.model.playedGames.toString() }
            itemCompetitionerWTextview.text = let { item.model.wins.toString() }
            itemCompetitionerDTextview.text = let { item.model.draws.toString() }
            itemCompetitionerLTextview.text = let { item.model.losses.toString() }
            itemCompetitionerGdTextview.text = let { item.model.goalDifference.toString() }
            itemCompetitionerPtsTextview.text = let { item.model.points.toString() }

//            when {
//                position == WINNER_POSITION -> {
//                    holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.color_club_winner))
//                }
//                position <= CHAMPIONS_LEAGUE_MIN_POSITION -> {
//                    holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.color_club_cl))
//                }
//                position <= EUROPE_CUP_MIN_POSITION -> {
//                    holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.color_club_ec))
//                }
//                position >= LOSS_MIN_POSITION -> {
//                    holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.color_club_winner))
//                }
//                else -> holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.color_background))
//            }

            holder.itemView.setOnClickListener {
                listener(item.model)
            }
        }
    }
}

class LeagueViewHolder(val binding: ItemLeagueBinding) : RecyclerView.ViewHolder(binding.root)