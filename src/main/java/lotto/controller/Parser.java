package lotto.controller;

import static lotto.util.ErrorMessage.AMOUNT_IS_NOT_NUMBER;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String DELIMITER = ",";
    public static final String IS_INTEGER = "\\d+";

    public int parseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(AMOUNT_IS_NOT_NUMBER.getMessage());
        }
    }

    public List<Integer> parseWinningNumber(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .filter(str -> str.matches(IS_INTEGER))
                .map(Integer::parseInt)
                .toList();
    }
}
