package com.dimchel.feature_competitions_api.data.models

class CompetitionModel(
    val id: Int,
    val name: String,
    val code: String?,
    val lastUpdated: String
)

class LeagueModel(
    val id: Int,
    val name: String,
    val standings: List<CompetitorModel>
)

class CompetitorModel(
    val position: Int,
    val team: TeamModel,
    val playedGames: Int,
    val won: Int,
    val draw: Int,
    val lost: Int,
    val points: Int,
    val goalsFor: Int,
    val goalsAgainst: Int,
    val goalDifference: Int
)

class TeamModel(
    val id: Int,
    val name: String,
    val crestUrl: String
)