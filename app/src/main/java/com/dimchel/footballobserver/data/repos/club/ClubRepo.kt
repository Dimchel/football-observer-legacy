package com.dimchel.footballobserver.data.repos.club

import com.dimchel.footballobserver.data.repos.Repo
import io.reactivex.Single


interface ClubRepo : Repo {

    fun getClub(clubId: Long): Single<List<ClubModel>>
    fun getPlayersList(clubId: Long): Single<List<PlayerModel>>

}