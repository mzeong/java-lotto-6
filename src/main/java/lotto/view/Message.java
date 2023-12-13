package lotto.view;

public enum Message {
    INPUT_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_LOTTO_COUNT("%d개를 구매했습니다."),
    OUTPUT_RANK_MATCH_COUNT("%d개 일치"),
    OUTPUT_RANK_MATCH_BONUS(", 보너스 볼 일치"),
    OUTPUT_RANK_PRIZE(" (%,d원)"),
    OUTPUT_RANK_LOTTO_COUNT(" - %d개"),
    OUTPUT_RESULT("당첨 통계\n---"),
    OUTPUT_PROFITRATE("총 수익률은 %,.1f%%입니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getFormattedMessage(final int value) {
        return String.format(message, value);
    }

    public String getFormattedMessage(final double value) {
        return String.format(message, value);
    }
}
