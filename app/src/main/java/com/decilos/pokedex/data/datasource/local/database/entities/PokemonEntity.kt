package com.decilos.pokedex.data.datasource.local.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.decilos.pokedex.domain.model.PokemonDetailModel

@Entity(tableName = "pokemon_table")
data class PokemonEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") val id: Int = 0,
    @ColumnInfo("name") val name: String = "",
    @ColumnInfo("url") val url: String = "",
    @ColumnInfo("detail") val detail: PokemonDetailModel
)
