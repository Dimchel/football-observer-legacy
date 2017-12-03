package com.dimchel.footballobserver.presentation.competitions

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dimchel.footballobserver.R
import com.dimchel.footballobserver.common.simpleclasses.SimpleOnItemSelectedListener
import com.dimchel.footballobserver.data.networks.models.responses.CompetitionScheme
import kotlinx.android.synthetic.main.item_competition.view.*


class CompetitionsRvAdapter(private val listener: SimpleOnItemSelectedListener<CompetitionScheme>) : RecyclerView.Adapter<CompetitionsRvAdapter.ViewHolder>() {

    var competitionsList: List<CompetitionScheme> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_competition, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
         with(competitionsList[position]) {

             holder!!.nameTextView.text = let { caption }

             holder.itemView.setOnClickListener {
                 listener.onItemSelected(let { this })
             }
         }
    }

    override fun getItemCount(): Int {
        return competitionsList.size
    }

    fun setData(competitionsList: List<CompetitionScheme>) {
        this.competitionsList = competitionsList

        this.notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nameTextView = itemView.item_competition_name_textview!!
    }

}