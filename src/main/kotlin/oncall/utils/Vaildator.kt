package oncall.utils

class Validator {
    fun validateComma(input : String){
        require(input.trim().contains(",")){"구분자는 쉼표로 표기 해주시기 바랍니다"}
    }

    fun validateMonth(input : String){
        require(input.toInt() > 0) {"1~12 까지 입력 가능합니다"}
        require(input.toInt() <= 12) {"1~12 까지 입력 가능합니다"}
    }
    fun validateDate(input : String){
        require(input == "월" || input == "화" || input == "수" || input == "목" || input == "금"
                || input == "토" || input == "일"){"월,화,수,목,금,토,일 만 입력 가능합니다"}
    }

}