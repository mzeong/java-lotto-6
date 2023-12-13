package lotto.view;

import static lotto.view.Message.INPUT_AMOUNT;
import static lotto.view.Message.INPUT_BONUS_NUMBER;
import static lotto.view.Message.INPUT_WINNING_NUMBER;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputAmount() {
        printMessage(INPUT_AMOUNT);
        return Console.readLine();
    }

    public String inputWinningNumber() {
        printMessage(INPUT_WINNING_NUMBER);
        return Console.readLine();
    }

    public String inputBonusNumber() {
        printMessage(INPUT_BONUS_NUMBER);
        return Console.readLine();
    }

    public static void printMessage(Message message) {
        System.out.println(message.getMessage());
    }
}
