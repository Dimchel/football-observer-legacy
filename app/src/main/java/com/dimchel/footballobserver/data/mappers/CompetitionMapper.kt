package com.dimchel.footballobserver.data.mappers

import com.dimchel.footballobserver.data.networks.models.responses.CompetitionScheme
import com.dimchel.footballobserver.data.repos.competitions.CompetitionModel


class CompetitionMapper {

    fun mapCompetitionSchemeToCompetitionModel(scheme: CompetitionScheme): CompetitionModel {
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

    fun mapCompetitionSchemesListToCompetitionModelsList(schemesList: List<CompetitionScheme>): List<CompetitionModel> {
        val result = ArrayList<CompetitionModel>()

        return schemesList.mapTo(result) { mapCompetitionSchemeToCompetitionModel(it) }
    }

}