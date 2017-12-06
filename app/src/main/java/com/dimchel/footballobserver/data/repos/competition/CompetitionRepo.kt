package com.dimchel.footballobserver.data.repos.competition

import com.dimchel.footballobserver.data.repos.Repo
import com.dimchel.footballobserver.data.repos.competition.models.CompetitionModel
import com.dimchel.footballobserver.data.repos.competition.models.LeagueModel
import io.reactivex.Single


interface CompetitionRepo : Repo {

    fun getCompetitionsList(): Single<List<CompetitionModel>>
    fun getLeagueTable(competitionId: Long): Single<LeagueModel>

}