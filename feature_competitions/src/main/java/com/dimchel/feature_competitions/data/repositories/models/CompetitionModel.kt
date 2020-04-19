package com.dimchel.feature_competitions.data.repositories.models

class CompetitionModel(
    val id: Long,
    val caption: String,
    val league: String,
    val year: Int,
    val currentMatchday: Int,
    val numberOfMatchdays: Int,
    val numberOfTeams: Int,
    val numberOfGames: Int,
    val lastUpdated: String
)