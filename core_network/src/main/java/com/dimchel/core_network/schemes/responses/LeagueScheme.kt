package com.dimchel.core_network.schemes.responses

class LeagueScheme(
	val competition: LeagueInfoScheme,
	val standings: List<StandingsScheme>
)

class LeagueInfoScheme(
	val id: Int,
	val name: String
)

class StandingsScheme(
	val table: List<CompetitorScheme>
)

class CompetitorScheme(
	val position: Int,
	val team: TeamScheme,
	val playedGames: Int,
	val won: Int,
	val draw: Int,
	val lost: Int,
	val points: Int,
	val goalsFor: Int,
	val goalsAgainst: Int,
	val goalDifference: Int
)

class TeamScheme(
	val id: Int,
	val name: String,
	val crestUrl: String
)