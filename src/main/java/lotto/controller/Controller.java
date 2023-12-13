package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Amount;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Result;
import lotto.util.RandomNumberGenerator;
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

    public void run() {
        Amount amount = getAmount();
        int count = amount.calculateLottoCount();
        Lottos lottos = new Lottos(count, new RandomNumberGenerator());
        outputView.printLottoCount(count);
        outputView.printLottos(lottos);

        Lotto winningLotto = getWinningNumber();
        BonusNumber bonusNumber = getBonusNumber(winningLotto);
        Result result = new Result(lottos, winningLotto, bonusNumber);
        outputView.printResult(result);
        outputView.printProfitRate(amount.calculateProfitRate(result.calculateProfit()));

        Console.close();
    }

    private Amount getAmount() {
        while (true) {
            try {
                return new Amount(parser.parseAmount(inputView.inputAmount()));
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

    private BonusNumber getBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                int bonusNumber = parser.parseBonusNumber(inputView.inputBonusNumber());
                return new BonusNumber(winningLotto, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
