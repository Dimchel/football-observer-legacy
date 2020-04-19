package com.dimchel.core_network.schemes.responses

class LeagueScheme(
	val leagueCaption: String,
	val matchday: Int,
	val standing: List<CompetitionerScheme>
)