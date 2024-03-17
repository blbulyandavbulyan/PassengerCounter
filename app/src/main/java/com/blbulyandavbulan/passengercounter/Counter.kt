package com.blbulyandavbulan.passengercounter

import android.widget.TextView

class Counter(private val textView: TextView) {
    var value = 0
        private set

    init {
        textView.text = "0"
    }

    fun inc() {
        value++
        textView.text = value.toString()
    }

    fun dec() {
        if (value > 0) value--
        textView.text = value.toString()
    }

    fun isMinimum(): Boolean = value == 0
}