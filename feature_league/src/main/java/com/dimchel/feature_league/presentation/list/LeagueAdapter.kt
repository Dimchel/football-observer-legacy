package com.dimchel.feature_league.presentation.list

import com.dimchel.feature_competitions_api.data.models.CompetitionerModel
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

sealed class LeagueListModel {
    object HeaderListModel : LeagueListModel()
    class CompetitionerListModel(val model: CompetitionerModel) : LeagueListModel()
}

class LeagueAdapter(
    listener: (competitionModel: CompetitionerModel) -> Unit
) : ListDelegationAdapter<List<LeagueListModel>>() {

    init {
        delegatesManager.addDelegate(HeaderDelegate())
        delegatesManager.addDelegate(LeagueDelegate(listener))
    }

    fun setData(competitionsList: List<LeagueListModel>) {
        items = competitionsList

        notifyItemRangeInserted(0, items.size - 1)
    }
}