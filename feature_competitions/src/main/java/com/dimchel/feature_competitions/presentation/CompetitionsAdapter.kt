package com.dimchel.feature_competitions.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dimchel.feature_competitions.data.repositories.models.CompetitionModel
import com.dimchel.feature_competitions.databinding.CompetitionsItemBinding
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class CompetitionsAdapter(
    listener: (competitionModel: CompetitionModel) -> Unit
) : ListDelegationAdapter<List<CompetitionModel>>() {

    init {
        delegatesManager.addDelegate(CompetitionsDelegate(listener))
    }

    fun setData(competitionsList: List<CompetitionModel>) {
        items = competitionsList

        notifyItemRangeInserted(0, items.size - 1)
    }
}

private class CompetitionsDelegate(
    private val listener: (competitionModel: CompetitionModel) -> Unit
): AbsListItemAdapterDelegate<CompetitionModel, CompetitionModel, ViewHolder>() {

    override fun isForViewType(
        item: CompetitionModel,
        items: MutableList<CompetitionModel>,
        position: Int
    ): Boolean = true

    override fun onCreateViewHolder(parent: ViewGroup) = ViewHolder(
        CompetitionsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(
        item: CompetitionModel,
        holder: ViewHolder,
        payloads: MutableList<Any>
    ) {
        with(holder.binding) {
            itemCompetitionNameTextview.text = let { item.name }
            itemCompetitionUpdatedTextview.text = let { item.lastUpdated }

            root.setOnClickListener {
                listener.invoke(item)
            }
        }
    }

}

private class ViewHolder(val binding: CompetitionsItemBinding) : RecyclerView.ViewHolder(binding.root)