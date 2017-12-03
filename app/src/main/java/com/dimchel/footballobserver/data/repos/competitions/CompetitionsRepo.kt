package com.dimchel.footballobserver.data.repos.competitions

import com.dimchel.footballobserver.data.repos.Repo
import io.reactivex.Single


interface CompetitionsRepo: Repo {

    fun getCompetitionsList(): Single<List<CompetitionModel>>

}