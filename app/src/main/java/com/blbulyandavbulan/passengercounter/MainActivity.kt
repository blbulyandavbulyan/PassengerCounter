package com.blbulyandavbulan.passengercounter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.blbulyandavbulan.passengercounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val maxPlacesCount = 50
        val counter = PlacesCounter(maxPlacesCount) { binding.counterTextView.text = it.toString() }
        val detailsDisplay = DetailsDisplay(binding.detailsTextView, counter)
        val decButton = binding.decButton
        val resetButton = binding.resetButton
        decButton.isEnabled = false
        decButton.setOnClickListener {
            counter.dec()
            detailsDisplay.update()
            if (counter.isMinReached()) {
                decButton.isEnabled = false;
            }
            if (!counter.isMaxReached()) {
                resetButton.isVisible = false
            }
        }
        binding.incButton.setOnClickListener {
            counter.inc()
            decButton.isEnabled = true
            detailsDisplay.update()
            if (counter.isMaxReached()) {
                resetButton.isVisible = true
            }
        }
        resetButton.isVisible = false;
        resetButton.setOnClickListener {
            counter.reset()
            decButton.isEnabled = false
            resetButton.isVisible = false;
            detailsDisplay.update()
        }
    }
}