package com.dimchel.footballobserver.data.repos.competition.models


data class LeagueModel(
        val leagueCaption: String,
        val matchday: Int,
        val standing: List<CompetitionerModel>
)