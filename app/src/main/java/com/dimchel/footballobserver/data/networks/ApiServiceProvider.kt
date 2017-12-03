package com.dimchel.footballobserver.data.networks

import com.dimchel.footballobserver.data.networks.models.responses.CompetitionScheme


interface ApiServiceProvider {

    fun fetchCompetitions(listenerNetwork: OnNetworkDataListener<List<CompetitionScheme>>)

}