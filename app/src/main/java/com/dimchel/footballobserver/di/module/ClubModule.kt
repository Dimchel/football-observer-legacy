package com.dimchel.footballobserver.di.module

import com.dimchel.footballobserver.data.mappers.ClubMapper
import com.dimchel.footballobserver.data.networks.ApiServiceProvider
import com.dimchel.footballobserver.data.repos.club.ClubRepo
import com.dimchel.footballobserver.di.scopes.ClubScope
import dagger.Provides


class ClubModule {

    @ClubScope
    @Provides
    fun provideClubMapper(): ClubMapper {
        return ClubMapper()
    }

    @ClubScope
    @Provides
    fun provideClubRepo(apiProvider: ApiServiceProvider, mapper: ClubMapper): ClubRepo {
        return ClubRepoImpl(apiProvider, mapper)
    }

}