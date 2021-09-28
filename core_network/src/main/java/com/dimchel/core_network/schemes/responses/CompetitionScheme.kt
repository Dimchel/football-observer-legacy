package com.dimchel.core_network.schemes.responses

class CompetitionsScheme(
    val competitions: List<CompetitionScheme>
)

class CompetitionScheme(
    val id: Int,
    val name: String,
    val code: String?,
    val lastUpdated: String
)