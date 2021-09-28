package com.dimchel.feature_league.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dimchel.core_image_loader.image_loader.ImageLoaderProvider
import com.dimchel.feature_competitions_api.data.models.CompetitorModel
import com.dimchel.feature_league.databinding.ItemLeagueBinding
import com.dimchel.feature_league.presentation.list.LeagueListModel.CompetitorListModel
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class LeagueDelegate(
    private val imageLoaderProvider: ImageLoaderProvider,
    private val listener: (competitionModel: CompetitorModel) -> Unit
): AbsListItemAdapterDelegate<CompetitorListModel, LeagueListModel, LeagueViewHolder>() {

    override fun isForViewType(
        item: LeagueListModel,
        items: MutableList<LeagueListModel>,
        position: Int
    ): Boolean = item is CompetitorListModel

    override fun onCreateViewHolder(parent: ViewGroup) = LeagueViewHolder(
        ItemLeagueBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(
        item: CompetitorListModel,
        holder: LeagueViewHolder,
        payloads: MutableList<Any>
    ) {
        holder.binding.apply {
            imageLoaderProvider.loadImage(
                item.model.team.crestUrl,
                itemCompetitionerIconImageview
            )
            itemCompetitionerNameTextview.text = let { item.model.team.name }
            itemCompetitionerPosTextview.text = (holder.adapterPosition).toString()
            itemCompetitionerPTextview.text = let { item.model.playedGames.toString() }
            itemCompetitionerWTextview.text = let { item.model.won.toString() }
            itemCompetitionerDTextview.text = let { item.model.draw.toString() }
            itemCompetitionerLTextview.text = let { item.model.lost.toString() }
            itemCompetitionerGdTextview.text = let { item.model.goalDifference.toString() }
            itemCompetitionerPtsTextview.text = let { item.model.points.toString() }

            holder.itemView.setOnClickListener {
                listener(item.model)
            }
        }
    }
}

class LeagueViewHolder(val binding: ItemLeagueBinding) : RecyclerView.ViewHolder(binding.root)