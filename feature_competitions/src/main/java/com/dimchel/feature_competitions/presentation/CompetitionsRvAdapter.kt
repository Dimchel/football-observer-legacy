package com.dimchel.feature_competitions.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dimchel.feature_competitions.R
import com.dimchel.feature_competitions.data.repositories.models.CompetitionModel

class CompetitionsRvAdapter(
    private val listener: (competitionModel: CompetitionModel) -> Unit
) : RecyclerView.Adapter<CompetitionsRvAdapter.ViewHolder>() {

    private var competitionsList: List<CompetitionModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.competitions_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(competitionsList[position]) {

            holder.nameTextView.text = let { name }
//            holder.matchdayTextView.text = let { currentMatchday.toString() }
//            holder.teamTextView.text = let { numberOfTeams.toString() }
            holder.updatedTextView.text = let { lastUpdated }

            holder.itemView.setOnClickListener {
                listener.invoke(this)
            }
        }
    }

    override fun getItemCount(): Int {
        return competitionsList.size
    }

    fun setData(competitionsList: List<CompetitionModel>) {
        this.competitionsList = competitionsList

        this.notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.item_competition_name_textview)
        val updatedTextView: TextView = itemView.findViewById(R.id.item_competition_updated_textview)
        val teamTextView: TextView = itemView.findViewById(R.id.item_competition_teams_textview)
        val matchdayTextView: TextView = itemView.findViewById(R.id.item_competition_matchday_textview)
    }
}