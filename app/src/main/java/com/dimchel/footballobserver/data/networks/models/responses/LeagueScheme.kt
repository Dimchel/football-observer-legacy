package com.dimchel.footballobserver.data.networks.models.responses

import com.google.gson.annotations.SerializedName


data class LeagueScheme(
        @SerializedName("leagueCaption")
        val leagueCaption: String,

        @SerializedName("matchday")
        val matchday: Int,

        @SerializedName("standing")
        val standing: List<CompetitionerScheme>
)