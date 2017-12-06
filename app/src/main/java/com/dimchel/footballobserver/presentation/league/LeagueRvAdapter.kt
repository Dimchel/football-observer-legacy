package com.dimchel.footballobserver.presentation.league

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dimchel.footballobserver.R
import com.dimchel.footballobserver.common.simpleclasses.SimpleOnItemSelectedListener
import com.dimchel.footballobserver.data.repos.competition.models.CompetitionerModel
import kotlinx.android.synthetic.main.item_competitioner.view.*


class LeagueRvAdapter(private val listener: SimpleOnItemSelectedListener<CompetitionerModel>) : RecyclerView.Adapter<LeagueRvAdapter.ViewHolder>() {

    var competitionersList: List<CompetitionerModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_competitioner, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        with(competitionersList[position]) {

            holder!!.nameTextView.text = let { teamName }

            holder.itemView.setOnClickListener {
                listener.onItemSelected(let { this })
            }
        }
    }

    override fun getItemCount(): Int {
        return competitionersList.size
    }

    fun setData(competitionersList: List<CompetitionerModel>) {
        this.competitionersList = competitionersList

        this.notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nameTextView = itemView.item_competitioner_name_textview!!
    }

}