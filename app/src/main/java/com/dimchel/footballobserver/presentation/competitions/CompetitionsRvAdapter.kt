package com.dimchel.footballobserver.presentation.competitions

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dimchel.footballobserver.R
import com.dimchel.footballobserver.common.simpleclasses.SimpleOnItemSelectedListener
import com.dimchel.footballobserver.data.repos.competition.models.CompetitionModel
import kotlinx.android.synthetic.main.item_competition.view.*


class CompetitionsRvAdapter(private val listener: SimpleOnItemSelectedListener<CompetitionModel>)
    : RecyclerView.Adapter<CompetitionsRvAdapter.ViewHolder>() {

    private var competitionsList: List<CompetitionModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_competition, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(competitionsList[position]) {

            holder.nameTextView.text = let { caption }
            holder.matchdayTextView.text = let { currentMatchday.toString() }
            holder.teamTextView.text = let { numberOfTeams.toString() }
            holder.updatedTextView.text = let { lastUpdated }

            holder.itemView.setOnClickListener {
                listener.onItemSelected(let { this })
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
        val nameTextView = itemView.item_competition_name_textview
        val updatedTextView = itemView.item_competition_updated_textview
        val teamTextView = itemView.item_competition_teams_textview
        val matchdayTextView = itemView.item_competition_matchday_textview
    }

}