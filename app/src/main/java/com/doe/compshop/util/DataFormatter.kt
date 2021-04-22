package com.doe.compshop.util

object DataFormatter {

    @OptIn(ExperimentalStdlibApi::class)
    fun capitalizeName(name: String) = name.take(0).lowercase()

}