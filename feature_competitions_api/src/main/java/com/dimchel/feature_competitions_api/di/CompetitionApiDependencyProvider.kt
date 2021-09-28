package com.dimchel.feature_competitions_api.di

import com.dimchel.feature_competitions_api.data.repositories.CompetitionRepository

interface CompetitionApiDependencyProvider {

    fun getCompetitionsRepository(): CompetitionRepository
}