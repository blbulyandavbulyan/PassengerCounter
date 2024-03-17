package com.blbulyandavbulan.passengercounter

class Counter(private val countChangedCallBack: (Int)->Unit) {
    var value = 0
        private set

    fun inc() {
        countChangedCallBack(++value)
    }

    fun dec() {
        if (value > 0) value--
        countChangedCallBack(value)
    }
    fun reset() {
        value = 0
        countChangedCallBack(value)
    }
    fun isMinimum(): Boolean = value == 0
}