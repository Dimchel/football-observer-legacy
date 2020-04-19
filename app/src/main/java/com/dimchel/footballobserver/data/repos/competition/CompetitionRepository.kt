package com.dimchel.footballobserver.data.repos.competition

import com.dimchel.core_architecture.repository.Repository
import com.dimchel.footballobserver.data.repos.competition.models.CompetitionModel
import com.dimchel.footballobserver.data.repos.competition.models.LeagueModel
import io.reactivex.Single


interface CompetitionRepository : com.dimchel.core_architecture.repository.Repository {

    fun getCompetitionsList(): Single<List<CompetitionModel>>
    fun getLeagueTable(competitionId: Long): Single<LeagueModel>

}