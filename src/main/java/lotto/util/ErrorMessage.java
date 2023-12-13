package lotto.util;

public enum ErrorMessage {
    DUPLICATE_NUMBER_EXISTS("중복되는 숫자가 있습니다."),
    NUMBER_OUT_OF_RANGE("범위를 벗어난 숫자가 포함되어 있습니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
