package lotto.controller;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public int parseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }

    public List<Integer> parseWinningNumber(String input) {
        List<String> list = Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(str -> !str.isEmpty())
                .toList();
        if (list.isEmpty()) {
            throw new IllegalArgumentException("입력이 없거나 쉼표나 공백으로만 구성됨");
        }
        try {
            return list.stream()
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아님");
        }
    }

    public int parseBonusNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }
}
