package oncall.controller

import oncall.model.MonthAndDate
import oncall.model.WeekDayWorker

class SaveToModel {
    fun saveMonthAndDate(monthAndDate: String): MonthAndDate {
        val saveToModel = monthAndDate.trim().split(",").map { it.trim() }
        return MonthAndDate(saveToModel[0].toInt(),saveToModel[1])
    }
    fun saveWeekDayWorker(weekDayWorker : String) : WeekDayWorker{
        val saveWeekDayWorker = weekDayWorker.trim().split(",").map { it.trim() }
        return WeekDayWorker(saveWeekDayWorker)
    }

}