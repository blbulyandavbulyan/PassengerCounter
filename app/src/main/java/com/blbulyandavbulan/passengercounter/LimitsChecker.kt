package com.blbulyandavbulan.passengercounter

interface LimitsChecker {
    fun isMinReached(): Boolean
    fun isMaxReached(): Boolean
}