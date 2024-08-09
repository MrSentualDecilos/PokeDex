package com.decilos.pokedex.data.datasource.local.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "result_table")
data class ResultEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("count") val count: Int = 0,
    @ColumnInfo("next") val next: String = "",
    @ColumnInfo("previous")  val previous: String ="",
    @ColumnInfo("results") val results: List<PokemonEntity> = emptyList()
)
