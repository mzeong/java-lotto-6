package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Answer;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final Parser parser;

    public Controller(InputView inputView, OutputView outputView, Parser parser) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.parser = parser;
    }

    public void init() {
        int amount = getAmount();
        Lotto winningNumber = getWinningNumber();
        Answer answerNumber = getBonusNumber(winningNumber);

        Console.close();
    }

    private int getAmount() {
        while (true) {
            try {
                return parser.parseAmount(inputView.inputAmount());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto getWinningNumber() {
        while (true) {
            try {
                List<Integer> winningNumber = parser.parseWinningNumber(inputView.inputWinningNumber());
                return new Lotto(winningNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Answer getBonusNumber(Lotto winningNumber) {
        while (true) {
            try {
                int bonusNumber = parser.parseBonusNumber(inputView.inputBonusNumber());
                return new Answer(winningNumber, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
