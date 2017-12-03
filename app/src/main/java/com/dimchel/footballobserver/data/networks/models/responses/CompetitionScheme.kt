package com.dimchel.footballobserver.data.networks.models.responses


data class CompetitionScheme(
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