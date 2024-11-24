package oncall.controller

import oncall.utils.Validator
import oncall.view.InputView

class OncallController(private val inputView: InputView,
                       private val validator: Validator) {

    fun run(){
        try {
            val monthAndDate = inputView.inputMonthAndDate()
            checkComma(monthAndDate)
            checkMonthAndDate(monthAndDate)
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
            return step3()
        } catch (e : IllegalArgumentException){
            println(e)
            step2()
        }
    }
    fun step3(){
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
}