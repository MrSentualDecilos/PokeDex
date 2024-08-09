package com.decilos.pokedex.core.common

interface Mapper<F, T> {
    fun mapFrom(from: F): T
}
