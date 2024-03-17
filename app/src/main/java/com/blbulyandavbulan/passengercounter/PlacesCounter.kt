package com.blbulyandavbulan.passengercounter

class PlacesCounter(
    private val maxPlacesCount: Int,
    private val countChangedCallBack: (Int) -> Unit
) : PlacesStatistics {
    private var placesTaken = 0
    override var placesLeft = maxPlacesCount
        private set
        get() = maxPlacesCount - placesTaken
    fun inc() {
        countChangedCallBack(++placesTaken)
    }

    fun dec() {
        if (placesTaken > 0) placesTaken--
        countChangedCallBack(placesTaken)
    }

    fun reset() {
        placesTaken = 0
        countChangedCallBack(placesTaken)
    }

    override fun isMinReached() = placesTaken == 0
    override fun isMaxReached() = placesTaken >= maxPlacesCount
}