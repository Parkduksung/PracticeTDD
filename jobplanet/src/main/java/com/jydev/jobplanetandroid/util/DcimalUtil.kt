package com.jydev.jobplanetandroid.util

import java.text.DecimalFormat

fun Int.getCommaDecimal() : String {
    val decimalFormat = DecimalFormat("###,###")
    return decimalFormat.format(this)
}