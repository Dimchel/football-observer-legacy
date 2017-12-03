package com.dimchel.footballobserver.data.repos.competitions

import com.dimchel.footballobserver.common.Logger
import com.dimchel.footballobserver.data.networks.ApiServiceProvider


class CompetitionsRepoImpl(apiProvider: ApiServiceProvider): CompetitionsRepo {

    override fun log() {
        Logger.log("123", "yea!")
    }
}