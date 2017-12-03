package com.dimchel.footballobserver.data.networks

import com.dimchel.footballobserver.data.networks.api.FootballApiService
import com.dimchel.footballobserver.data.networks.models.responses.CompetitionScheme
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class ApiServiceProviderImpl(private val apiService: FootballApiService) : ApiServiceProvider {

    override fun fetchCompetitions(): Single<List<CompetitionScheme>> {
        return apiService.getCompetitionsList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

}