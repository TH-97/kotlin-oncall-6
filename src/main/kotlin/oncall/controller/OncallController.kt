package oncall.controller

import oncall.utils.Validator
import oncall.view.InputView

class OncallController(
    private val inputView: InputView,
    private val validator: Validator,
    private val saveToModel: SaveToModel
) {

    fun run(){
        try {
            val monthAndDate = inputView.inputMonthAndDate()
            checkComma(monthAndDate)
            checkMonthAndDate(monthAndDate)
            val saveMonthAndDate = saveToModel.saveMonthAndDate(monthAndDate)
            return step2()
        } catch (e: IllegalArgumentException){
            println(e)
            run()
        }
    }
    fun step2(){
        try {
            val weekDayWorker = inputView.inputWeekDayWorker()
            checkComma(weekDayWorker)
            checkWeekDayWorker(weekDayWorker)
            val saveWeekDayWorker = saveToModel.saveWeekDayWorker(weekDayWorker)
            return step3(weekDayWorker.trim().split(",").map { it.trim() })
        } catch (e : IllegalArgumentException){
            println(e)
            step2()
        }
    }
    fun step3(weekDayWorkerList: List<String>) {
        try {
            val holidayDayWorker = inputView.inputHolidayWorker()
            checkComma(holidayDayWorker)
            checkHolidayDayWorker(holidayDayWorker,weekDayWorkerList)
        }catch (e: IllegalArgumentException){
            println(e)
            step3(weekDayWorkerList)
        }
    }
    fun finalStep(){

    }
    fun checkComma(input : String){
        validator.validateComma(input)
    }
    fun checkMonthAndDate(passInputComma: String){
        try {
            val monthAndDate = passInputComma.trim().split(",")
            validator.validateMonth(monthAndDate[0].trim())
            validator.validateDate(monthAndDate[1].trim())
        } catch (e: IllegalArgumentException){
            println(e)
            return run()
        }
    }
    fun checkWeekDayWorker(passInputComma: String){
        try {
            val weekDatWorker = passInputComma
            validator.validateWeekDayWorker(weekDatWorker)
        }catch (e: IllegalArgumentException){
            println(e)
            return step2()
        }
    }
    fun checkHolidayDayWorker(passInputComma: String, weekDayWorkerList: List<String>){
        try {
            val holidayWorker = passInputComma
            validator.validateHolidayWorker(holidayWorker,weekDayWorkerList)

        }catch (e: IllegalArgumentException){
            println(e)
            return step2()
        }
    }
}