package com.dimchel.feature_league.presentation.list

import com.dimchel.core_image_loader.image_loader.ImageLoaderProvider
import com.dimchel.feature_competitions_api.data.models.CompetitorModel
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

sealed class LeagueListModel {
    object HeaderListModel : LeagueListModel()
    class CompetitorListModel(val model: CompetitorModel) : LeagueListModel()
}

class LeagueAdapter(
    imageLoaderProvider: ImageLoaderProvider,
    listener: (competitionModel: CompetitorModel) -> Unit
) : ListDelegationAdapter<List<LeagueListModel>>() {

    init {
        delegatesManager.addDelegate(HeaderDelegate())
        delegatesManager.addDelegate(LeagueDelegate(imageLoaderProvider, listener))
    }

    fun setData(competitionsList: List<LeagueListModel>) {
        items = competitionsList

        notifyItemRangeInserted(0, items.size - 1)
    }
}