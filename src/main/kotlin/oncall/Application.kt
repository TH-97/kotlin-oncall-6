package oncall

import oncall.controller.OncallController
import oncall.controller.SaveToModel
import oncall.utils.Validator
import oncall.view.InputView

fun main() {
    val inputView = InputView()
    val validator = Validator()
    val saveToModel = SaveToModel()
    OncallController(inputView,validator,saveToModel).run()
}
