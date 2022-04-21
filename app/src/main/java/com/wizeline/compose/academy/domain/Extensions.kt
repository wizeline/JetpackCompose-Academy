package com.wizeline.compose.academy.domain

import java.text.DecimalFormat

fun Double.getFormatMoney(): String {
    val formatter = DecimalFormat("#,###.00")
    return formatter.format(this)
}