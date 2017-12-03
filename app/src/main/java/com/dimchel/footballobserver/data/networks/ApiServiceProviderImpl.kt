package com.dimchel.footballobserver.data.networks

import com.dimchel.footballobserver.data.networks.api.FootballApiService
import com.dimchel.footballobserver.data.networks.models.responses.CompetitionScheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ApiServiceProviderImpl(private val apiService: FootballApiService) : ApiServiceProvider {

    override fun fetchCompetitions(listenerNetwork: OnNetworkDataListener<List<CompetitionScheme>>) {

        apiService.getCompetitionsList().enqueue(object : Callback<List<CompetitionScheme>> {
            override fun onResponse(call: Call<List<CompetitionScheme>>?, response: Response<List<CompetitionScheme>>?) {
                if (response != null) {
                    val result = response.body()

                    if (result != null) {
                        listenerNetwork.onResult(result)
                    }
                }
            }
            override fun onFailure(call: Call<List<CompetitionScheme>>?, t: Throwable?) {
                listenerNetwork.onFailure(NetworkError.NO_CONNECTION)
            }
        })
    }

}