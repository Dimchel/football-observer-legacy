package com.dimchel.feature_competitions_api.data.models

class CompetitionerModel(
    var rank: Int,
    var teamName: String,
    var teamId: Int,
    var playedGames: Int,
    var crestURI: String?,
    var points: Int,
    var goals: Int,
    var goalsAgainst: Int,
    var goalDifference: Int,
    val wins: Int,
    val draws: Int,
    val losses: Int
)