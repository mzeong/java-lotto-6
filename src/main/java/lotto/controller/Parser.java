package lotto.controller;

import static lotto.util.ErrorMessage.AMOUNT_IS_NOT_NUMBER;

public class Parser {
    public int parseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(AMOUNT_IS_NOT_NUMBER.getMessage());
        }
    }
}
