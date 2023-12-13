package lotto.domain;

import static lotto.util.ErrorMessage.AMOUNT_OUT_OF_RANGE;
import static lotto.util.ErrorMessage.INVALID_UNIT;

public class Amount {
    public static final int UNIT = 1000;
    private final int amount;

    public Amount(int amount) {
        validateUnit(amount);
        validateRange(amount);
        this.amount = amount;
    }

    private void validateUnit(int amount) {
        if (amount % UNIT != 0) {
            throw new IllegalArgumentException(INVALID_UNIT.getMessage());
        }
    }

    private void validateRange(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(AMOUNT_OUT_OF_RANGE.getMessage());
        }
    }
}
