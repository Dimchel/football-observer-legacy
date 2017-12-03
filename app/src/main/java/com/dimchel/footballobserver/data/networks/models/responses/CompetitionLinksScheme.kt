package com.dimchel.footballobserver.data.networks.models.responses


data class CompetitionLinksScheme(
        val self: LinkScheme,
        val teams: LinkScheme,
        val fixtures: LinkScheme,
        val leagueTable: LinkScheme
)