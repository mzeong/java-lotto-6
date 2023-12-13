package lotto.view;

import static lotto.view.Message.INPUT_AMOUNT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputAmount() {
        printMessage(INPUT_AMOUNT);
        return Console.readLine();
    }

    public void printMessage(Message message) {
        System.out.println(message.getMessage());
    }
}
