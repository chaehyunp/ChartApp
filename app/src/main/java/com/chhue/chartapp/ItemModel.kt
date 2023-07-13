package com.chhue.chartapp

class Item {
    var time = 0.0
    var red1 = 0.0
    var red2 = 0.0
    var red3 = 0.0
    var blue1 = 0.0
    var blue2 = 0.0
    var blue3 = 0.0

    // Time
    fun getTime(): Double {
        return time
    }
    fun setTime(time: Double) {
        this.time = time
    }

    // Red1
    fun getRed1(): Double {
        return red1
    }
    fun setRed1(red1 :Double) {
        this.red1 = red1
    }

    // Red2
    fun getRed2(): Double {
        return red2
    }
    fun setRed2(red2 :Double) {
        this.red2 = red2
    }

    // Red3
    fun getRed3(): Double {
        return red3
    }

    fun setRed3(red3 :Double) {
        this.red3 = red3
    }

    // Blue1
    fun getBlue1(): Double {
        return blue1
    }
    fun setBlue1(blue1 :Double) {
        this.blue1 = blue1
    }

    // Blue2
    fun getBlue2(): Double {
        return blue2
    }
    fun setBlue2(blue2 :Double) {
        this.blue2 = blue2
    }

    // Blue3
    fun getBlue3(): Double {
        return blue3
    }
    fun setBlue3(blue3 :Double) {
        this.blue3 = blue3
    }
}
