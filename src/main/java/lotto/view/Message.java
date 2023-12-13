package lotto.view;

public enum Message {
    INPUT_AMOUNT("구입금액을 입력해 주세요.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
