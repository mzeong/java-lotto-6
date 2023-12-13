package lotto.domain;

import static lotto.util.ErrorMessage.DUPLICATE_NUMBER_EXISTS;
import static lotto.util.ErrorMessage.NUMBER_OUT_OF_RANGE;
import static lotto.util.ErrorMessage.NUMBER_SIZE_IS_WRONG;

import java.util.List;

public class Lotto {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNoOverlap(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(NUMBER_SIZE_IS_WRONG.getMessage());
        }
    }

    private void validateNoOverlap(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .toList();
        if (distinctNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_EXISTS.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number < MIN_NUMBER || number > MAX_NUMBER)
                .findAny()
                .ifPresent(outOfRange -> {
                    throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.getMessage());
                });
    }
}
