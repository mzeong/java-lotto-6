package lotto.domain;

import static lotto.domain.Lotto.isInvalidRange;
import static lotto.util.ErrorMessage.DUPLICATE_NUMBER_EXISTS;
import static lotto.util.ErrorMessage.NUMBER_OUT_OF_RANGE;

public class Answer {
    private final Lotto winningNumber;
    private final int bonusNumber;

    public Answer(Lotto winningNumber, int bonusNumber) {
        validateRange(bonusNumber);
        validateNoOverlap(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public static void validateRange(int bonusNumber) {
        if (isInvalidRange(bonusNumber)) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.getMessage());
        };
    }

    private void validateNoOverlap(Lotto winningNumber, int bonusNumber) {
        if (winningNumber.isDuplicated(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_EXISTS.getMessage());
        }
    }
}
