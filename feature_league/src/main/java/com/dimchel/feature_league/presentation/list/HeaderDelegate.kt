package com.dimchel.feature_league.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dimchel.feature_league.databinding.ItemLeagueBinding
import com.dimchel.feature_league.presentation.list.LeagueListModel.HeaderListModel
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class HeaderDelegate: AbsListItemAdapterDelegate<HeaderListModel, LeagueListModel, HeaderViewHolder>() {

    override fun isForViewType(
        item: LeagueListModel,
        items: MutableList<LeagueListModel>,
        position: Int
    ): Boolean = item is LeagueListModel.CompetitionerListModel

    override fun onCreateViewHolder(parent: ViewGroup) = HeaderViewHolder(
        ItemLeagueBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(
        item: HeaderListModel,
        holder: HeaderViewHolder,
        payloads: MutableList<Any>
    ) { }
}

class HeaderViewHolder(binding: ItemLeagueBinding) : RecyclerView.ViewHolder(binding.root)