package com.dimchel.footballobserver.data.managers

import android.support.annotation.DrawableRes
import com.dimchel.footballobserver.R


class IconManager {

    @DrawableRes
    fun getImageResource(teamTame: String):  Int {
        return when (teamTame) {
            "Manchester City FC" -> R.drawable.icon_team_manc
            "Manchester United FC" -> R.drawable.icon_team_manu
            "Chelsea FC" -> R.drawable.icon_team_che
            "Liverpool FC" -> R.drawable.icon_team_liv
            "Tottenham Hotspur FC" -> R.drawable.icon_team_tot
            "Arsenal FC" -> R.drawable.icon_team_ars
            "Burnley FC" -> R.drawable.icon_team_bur
            "Leicester City FC" -> R.drawable.icon_team_les
            "Watford FC" -> R.drawable.icon_team_wat
            "Everton FC" -> R.drawable.icon_team_eve
            "Huddersfield Town" -> R.drawable.icon_team_hud
            "Southampton FC" -> R.drawable.icon_team_sou
            "Brighton & Hove Albion" -> R.drawable.icon_team_bri
            "AFC Bournemouth" -> R.drawable.icon_team_bou
            "Stoke City FC" -> R.drawable.icon_team_sto
            "Newcastle United FC" -> R.drawable.icon_team_new
            "West Bromwich Albion FC" -> R.drawable.icon_team_wes
            "West Ham United FC" -> R.drawable.icon_team_weh
            "Swansea City FC" -> R.drawable.icon_team_swa
            "Crystal Palace FC" -> R.drawable.icon_team_cry
            else -> R.drawable.icon_team_placeholder
        }
    }

}