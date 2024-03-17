package com.blbulyandavbulan.passengercounter

interface PlacesStatistics {
    val placesLeft: Int
    fun isMinReached(): Boolean
    fun isMaxReached(): Boolean
}