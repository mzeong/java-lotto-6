package lotto.domain;

import static lotto.domain.Lotto.isInvalidRange;
import static lotto.util.ErrorMessage.DUPLICATE_NUMBER_EXISTS;
import static lotto.util.ErrorMessage.NUMBER_OUT_OF_RANGE;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(Lotto winningLotto, int bonusNumber) {
        validateRange(bonusNumber);
        validateNoOverlap(winningLotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private static void validateRange(int bonusNumber) {
        if (isInvalidRange(bonusNumber)) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.getMessage());
        };
    }

    private void validateNoOverlap(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_EXISTS.getMessage());
        }
    }

    public boolean isSame(int number) {
        return bonusNumber == number;
    }
}
