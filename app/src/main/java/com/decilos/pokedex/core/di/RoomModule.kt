package com.decilos.pokedex.core.di

import android.content.Context
import androidx.room.Room
import com.decilos.pokedex.data.datasource.local.database.PokemonDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Singleton
    @Provides
    fun provideDB(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, PokemonDataBase::class.java, DB_NAME).build()

    @Singleton
    @Provides
    fun providePokemonDao(dataBase: PokemonDataBase) = dataBase.getPokemonDao()

    companion object {
        const val DB_NAME = "pokemon_database"
    }
}
