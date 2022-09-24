package com.mahmoud_bashir.paginationcounterexamplewithkotlin.models

data class GetCharacterResponse(
    val info: Info,
    val results: List<Result>
)