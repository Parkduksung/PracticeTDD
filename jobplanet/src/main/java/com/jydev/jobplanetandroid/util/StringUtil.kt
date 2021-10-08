package com.jydev.jobplanetandroid.util

fun String.addQuotationMarks() : String{
    return if(this.isNotEmpty()) "\"$this\"" else ""
}