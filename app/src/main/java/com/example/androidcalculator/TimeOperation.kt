package com.example.androidcalculator

class TimeOperation(
    private var firstHour: Int, private var firstMinute: Int, private var firstSecond: Int,
    private var secondHour: Int, private var secondMinute: Int, private var secondSecond: Int) {

    fun dif() : String {
        var firstSummarySecond = firstSecond + (firstMinute * 60) + (firstHour * 3600)
        var secondSummarySecond = secondSecond + (secondMinute * 60) + (secondHour * 3600)
        var summaryResult = firstSummarySecond - secondSummarySecond
        val secondsResult = summaryResult % 60
        val minutesResult = summaryResult / 60 % 60
        val hoursResult = summaryResult / 3600
        return if (hoursResult != 0) "${hoursResult}h${minutesResult}m${secondsResult}s"
        else if (minutesResult != 0) "${minutesResult}m${secondsResult}s"
        else "${secondsResult}s"
    }
    fun sum() : String {
        var firstSummarySecond = firstSecond + (firstMinute * 60) + (firstHour * 3600)
        var secondSummarySecond = secondSecond + (secondMinute * 60) + (secondHour * 3600)
        var summaryResult = firstSummarySecond + secondSummarySecond
        val secondsResult = summaryResult % 60
        val minutesResult = summaryResult / 60 % 60
        val hoursResult = summaryResult / 3600
        return if (hoursResult != 0) "${hoursResult}h${minutesResult}m${secondsResult}s"
        else if (minutesResult != 0) "${minutesResult}m${secondsResult}s"
        else "${secondsResult}s"
    }

}