package com.blbulyandavbulan.passengercounter

import android.widget.TextView

class DetailsDisplay(
    private val detailsTextView: TextView,
    private val placesStatistics: PlacesStatistics
) {
    private val resources = detailsTextView.resources
    private fun showEveryPlacesEmptyText() {
        detailsTextView.text = resources.getString(R.string.allPlacesAreFree)
        detailsTextView.setTextColor(resources.getColor(R.color.allPlacesAreFree))
    }

    private fun showCountText(count: Int) {
        detailsTextView.text = resources.getString(R.string.countOfFreePlaces, count)
        detailsTextView.setTextColor(resources.getColor(R.color.countOfFreePlaces))
    }

    private fun showWarningText() {
        detailsTextView.text = resources.getString(R.string.tooManyPassengers)
        detailsTextView.setTextColor(resources.getColor(R.color.allPlacesAreTaken))
    }

    fun update() {
        if (placesStatistics.isMinReached()) {
            showEveryPlacesEmptyText()
        } else if (!placesStatistics.isMaxReached()) {
            showCountText(placesStatistics.placesLeft)
        } else {
            showWarningText()
        }
    }
}