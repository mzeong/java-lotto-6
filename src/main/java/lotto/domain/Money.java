package lotto.domain;

public class Money {
    private final int amount;

    public Money(int amount) {
        validateUnit(amount);
        this.amount = amount;
    }

    private void validateUnit(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }


}
