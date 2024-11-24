package oncall.utils

class Validator {
    fun validateComma(input : String){
        require(input.trim().contains(",")){"구분자는 쉼표로 표기 해주시기 바랍니다"}
        val inputValue = input.trim().split(",")
        for (value in inputValue){
            require(value.trim().isNotEmpty()){"공백은 값이 될 수 없습니다"}
        }
    }

    fun validateMonth(input : String){
        require(input.toInt() > 0) {"1~12 까지 입력 가능합니다"}
        require(input.toInt() <= 12) {"1~12 까지 입력 가능합니다"}
    }
    fun validateDate(input : String){
        require(input == "월" || input == "화" || input == "수" || input == "목" || input == "금"
                || input == "토" || input == "일"){"월,화,수,목,금,토,일 만 입력 가능합니다"}
    }
    fun validateWeekDayWorker(input : String){
        val inputValue = input.trim().split(",")

        require(inputValue.size >= 5) {"최소 근무자는 5명 입니다"}
        require(inputValue.size < 36) {"최대 근무자는 35명 입니다"}
        require(inputValue.size != input.toSet().size) {"한 근무자가 2번 편성될 수 없습니다"}
        for (value in inputValue){
            require(value.length <= 5) {"근무자의 닉네임은 최대5자 입니다"}
            require(!value.all { it.isDigit() }) {"닉네임에 숫자는 표기 불가능 합니다"}
        }
    }
    fun validateHolidayWorker(input: String, weekDayWorkerList: List<String>){
        val inputValue = input.trim().split(",")

        require(inputValue.size >= 5) {"최소 근무자는 5명 입니다"}
        require(inputValue.size < 36) {"최대 근무자는 35명 입니다"}
        require(inputValue.size != input.toSet().size) {"한 근무자가 2번 편성될 수 없습니다"}
        for (value in inputValue){
            require(weekDayWorkerList.contains(value)) {"평일 근무자와 휴일 근무자는 같아야 합니다"}
        }
    }

}