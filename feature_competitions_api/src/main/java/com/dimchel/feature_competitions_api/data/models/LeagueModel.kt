package com.dimchel.feature_competitions_api.data.models

class LeagueModel(
    val leagueCaption: String,
    val matchday: Int,
    val standing: List<CompetitionerModel>
)