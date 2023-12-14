package lotto.domain;

public class Money {
    private final int amount;

    public Money(int amount) {
        validateUnit(amount);
        validateRange(amount);
        this.amount = amount;
    }

    private void validateUnit(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    private void validateRange(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("구입 금액은 0 이하일 수 없습니다.");
        }
    }

    public int getAmount() {
        return amount;
    }

//    public int calculateCount() {
//        return amount / 1000;
//    }
//
//    public double calculateProfitRate(int profit) {
//        return (double) profit / amount * 100;
//    }
}
