package com.dimchel.footballobserver.data.networks.models.responses

import com.google.gson.annotations.SerializedName


data class CompetitionScheme(
        @SerializedName("id")
        val id: Long,

        @SerializedName("caption")
        val caption: String,

        @SerializedName("league")
        val league: String,

        @SerializedName("year")
        val year: Int,

        @SerializedName("currentMatchday")
        val currentMatchday: Int,

        @SerializedName("numberOfMatchdays")
        val numberOfMatchdays: Int,

        @SerializedName("numberOfTeams")
        val numberOfTeams: Int,

        @SerializedName("numberOfGames")
        val numberOfGames: Int,

        @SerializedName("lastUpdated")
        val lastUpdated: String
)