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
            val weekDayWorker = ""
        } catch (e : IllegalArgumentException){
            println(e)
            step2()
        }
    }
    fun checkComma(input : String){
        validator.validateComma(input)
    }
    fun checkMonthAndDate(passInputComma: String){
        try {
            val monthAndDate = passInputComma.trim().split(",")
            validator.validateMonth(monthAndDate[0])
            validator.validateDate(monthAndDate[1])
        } catch (e: IllegalArgumentException){
            println(e)
            return run()
        }
    }
}