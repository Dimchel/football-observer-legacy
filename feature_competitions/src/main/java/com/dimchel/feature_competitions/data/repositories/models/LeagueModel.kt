package com.dimchel.feature_competitions.data.repositories.models

class LeagueModel(
    val leagueCaption: String,
    val matchday: Int,
    val standing: List<CompetitionerModel>
)