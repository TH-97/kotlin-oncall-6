package oncall

import oncall.controller.OncallController
import oncall.utils.Validator
import oncall.view.InputView

fun main() {
    val inputView = InputView()
    val validator = Validator()
    OncallController(inputView,validator).run()
}
