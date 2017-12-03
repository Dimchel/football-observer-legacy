package com.dimchel.footballobserver.data.networks

import com.dimchel.footballobserver.data.networks.models.responses.CompetitionScheme
import io.reactivex.Single


interface ApiServiceProvider {

    fun fetchCompetitions(): Single<List<CompetitionScheme>>

}