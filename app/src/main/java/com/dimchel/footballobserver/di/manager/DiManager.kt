package com.dimchel.footballobserver.di.manager

import com.dimchel.footballobserver.di.component.CompetitionComponent
import com.dimchel.footballobserver.di.component.LeagueComponent


interface DiManager {

    fun getCompetitionComponent(tag: String): CompetitionComponent
    fun releaseCompetitionComponent(tag: String)

    fun getLeagueComponent(tag: String, leagueId: Long): LeagueComponent
    fun releaseLeagueComponent(tag: String)

}
