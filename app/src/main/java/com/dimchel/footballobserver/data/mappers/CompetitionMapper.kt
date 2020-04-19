package com.dimchel.footballobserver.data.mappers

import com.dimchel.core_network.schemes.responses.CompetitionScheme
import com.dimchel.core_network.schemes.responses.CompetitionerScheme
import com.dimchel.core_network.schemes.responses.LeagueScheme
import com.dimchel.footballobserver.data.repos.competition.models.CompetitionModel
import com.dimchel.footballobserver.data.repos.competition.models.CompetitionerModel
import com.dimchel.footballobserver.data.repos.competition.models.LeagueModel


class CompetitionMapper {

    private fun mapCompetitionSchemeToCompetitionModel(scheme: com.dimchel.core_network.schemes.responses.CompetitionScheme): CompetitionModel {
        return CompetitionModel(
                scheme.id,
                scheme.caption,
                scheme.league,
                scheme.year,
                scheme.currentMatchday,
                scheme.numberOfMatchdays,
                scheme.numberOfTeams,
                scheme.numberOfGames,
                scheme.lastUpdated
        )
    }

    fun mapCompetitionSchemesListToCompetitionModelsList(schemesList: List<com.dimchel.core_network.schemes.responses.CompetitionScheme>): List<CompetitionModel> {
        val result = ArrayList<CompetitionModel>()

        return schemesList.mapTo(result) { mapCompetitionSchemeToCompetitionModel(it) }
    }

    fun mapLeagueSchemeToLeagueModel(scheme: com.dimchel.core_network.schemes.responses.LeagueScheme): LeagueModel {
        return LeagueModel(
                scheme.leagueCaption,
                scheme.matchday,
                mapCompetitionerSchemesListTCompetitionerModelsList(scheme.standing)
        )
    }

    private fun mapCompetitionerSchemeToCompetitionerModel(scheme: com.dimchel.core_network.schemes.responses.CompetitionerScheme): CompetitionerModel {
        return CompetitionerModel(
                scheme.rank,
                scheme.teamName,
                scheme.links.teamLink.href.substring(scheme.links.teamLink.href.lastIndexOf('/') + 1).toInt(),
                scheme.playedGames,
                scheme.crestURI,
                scheme.points,
                scheme.goals,
                scheme.goalsAgainst,
                scheme.goalDifference,
                scheme.wins,
                scheme.draws,
                scheme.losses
        )
    }

    private fun mapCompetitionerSchemesListTCompetitionerModelsList(schemesList: List<com.dimchel.core_network.schemes.responses.CompetitionerScheme>): List<CompetitionerModel> {
        val result = ArrayList<CompetitionerModel>()

        return schemesList.mapTo(result) { mapCompetitionerSchemeToCompetitionerModel(it) }
    }

}