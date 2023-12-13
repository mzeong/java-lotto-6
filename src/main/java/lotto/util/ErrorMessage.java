package lotto.util;

public enum ErrorMessage {
    DUPLICATE_NUMBER_EXISTS("중복되는 숫자가 있습니다."),
    NUMBER_OUT_OF_RANGE("범위를 벗어난 숫자가 포함되어 있습니다."),
    INVALID_UNIT("금액이 1,000원 단위가 아닙니다."),
    AMOUNT_OUT_OF_RANGE("금액이 음수입니다."),
    AMOUNT_IS_NOT_NUMBER("금액이 숫자가 아닙니다."),
    NUMBER_SIZE_IS_WRONG("숫자 개수가 맞지 않습니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
