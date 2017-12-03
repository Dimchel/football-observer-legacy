package com.dimchel.footballobserver.data.repos.competitions

import com.dimchel.footballobserver.data.networks.models.responses.CompetitionScheme
import com.dimchel.footballobserver.data.repos.OnRepoDataListener
import com.dimchel.footballobserver.data.repos.Repo


interface CompetitionsRepo: Repo {

    fun getCompetitionsList(listener: OnRepoDataListener<List<CompetitionScheme>>)

}