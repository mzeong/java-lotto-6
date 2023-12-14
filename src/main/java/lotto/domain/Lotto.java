package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        long count = numbers.stream()
                .distinct()
                .count();
        if (count != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않아야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        long count = numbers.stream()
                .filter(number -> number < 1 || number > 45)
                .count();
        if (count > 0) {
            throw new IllegalArgumentException("로또 번호의 숫자 범위는 1~45까지입니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
