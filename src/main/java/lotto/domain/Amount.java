package lotto.domain;

import static lotto.util.ErrorMessage.INVALID_UNIT;

public class Amount {
    public static final int UNIT = 1000;
    private final int amount;

    public Amount(int amount) {
        validateRange(amount);
        this.amount = amount;
    }

    private void validateRange(int amount) {
        if (amount % UNIT != 0) {
            throw new IllegalArgumentException(INVALID_UNIT.getMessage());
        }
    }


}
