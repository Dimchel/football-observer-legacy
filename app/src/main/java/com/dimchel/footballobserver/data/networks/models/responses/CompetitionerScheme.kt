package com.dimchel.footballobserver.data.networks.models.responses

import com.google.gson.annotations.SerializedName


data class CompetitionerScheme(

        @SerializedName("rank")
        val rank: Int,

        @SerializedName("teamName")
        val teamName: String,

        @SerializedName("playedGames")
        val playedGames: Int,

        @SerializedName("crestURI")
        val crestURI: String,

        @SerializedName("points")
        val points: Int,

        @SerializedName("goals")
        val goals: Int,

        @SerializedName("goalsAgainst")
        val goalsAgainst: Int,

        @SerializedName("goalDifference")
        val goalDifference: Int,

        @SerializedName("wins")
        val wins: Int,

        @SerializedName("draws")
        val draws: Int,

        @SerializedName("losses")
        val losses: Int,

        @SerializedName("_links")
        val links: Links

){
    data class Links(
            @SerializedName("team")
            val teamLink: TeamLink
    )

    data class TeamLink(
            @SerializedName("href")
            val href: String
    )
}