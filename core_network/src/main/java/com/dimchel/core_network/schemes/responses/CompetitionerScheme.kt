package com.dimchel.core_network.schemes.responses

class CompetitionerScheme(
    val rank: Int,
    val teamName: String,
    val playedGames: Int,
    val crestURI: String,
    val points: Int,
    val goals: Int,
    val goalsAgainst: Int,
    val goalDifference: Int,
    val wins: Int,
    val draws: Int,
    val losses: Int,
    val links: Links
)

class Links(
    val teamLink: TeamLink
)

class TeamLink(
    val href: String
)