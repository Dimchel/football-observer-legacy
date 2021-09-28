package com.dimchel.feature_competitions_api.data.mappers

import com.dimchel.core_network.schemes.responses.CompetitionScheme
import com.dimchel.core_network.schemes.responses.CompetitorScheme
import com.dimchel.core_network.schemes.responses.LeagueScheme
import com.dimchel.core_network.schemes.responses.TeamScheme
import com.dimchel.feature_competitions_api.data.models.CompetitionModel
import com.dimchel.feature_competitions_api.data.models.CompetitorModel
import com.dimchel.feature_competitions_api.data.models.LeagueModel
import com.dimchel.feature_competitions_api.data.models.TeamModel

fun CompetitionScheme.mapToModel() = CompetitionModel(id, name, code, lastUpdated)

fun LeagueScheme.mapToModel() =
    LeagueModel(
        id = competition.id,
        name = competition.name,
        standings = standings.flatMap { standingsScheme -> standingsScheme.table.map { it.mapToModel() } }
    )

fun CompetitorScheme.mapToModel() =
    CompetitorModel(
        position,
        team = team.mapToModel(),
        playedGames,
        won,
        draw,
        lost,
        points,
        goalsFor,
        goalsAgainst,
        goalDifference
    )

fun TeamScheme.mapToModel() = TeamModel(id, name, crestUrl)