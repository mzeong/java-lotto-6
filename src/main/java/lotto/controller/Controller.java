package lotto.controller;

import java.util.EnumMap;
import lotto.domain.BonusNumber;
import lotto.domain.Calculator;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.util.RandomGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    public static final String PREFIX = "[ERROR] ";
    private final InputView inputView;
    private final OutputView outputView;
    private final Parser parser;

    public Controller(InputView inputView, OutputView outputView, Parser parser) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.parser = parser;
    }

    public void run() {
        Money money = getAmount();
        Lottos lottos = new Lottos(new RandomGenerator(), money);
        outputView.printLottos(money, lottos);

        Lotto winningLotto = getWinningLotto();
        BonusNumber bonusNumber = getBonusNumber(winningLotto);
        Calculator calculator = new Calculator(lottos, winningLotto, bonusNumber, money);
        EnumMap<Rank, Integer> result = calculator.calculateResult();
        Double profitRate = calculator.calculateProfitRate(result);
        outputView.printResult(result);
        outputView.printProfitRate(profitRate);
    }

    private Money getAmount() {
        while (true) {
            try {
                return new Money(parser.parseAmount(inputView.inputAmount()));
            } catch (IllegalArgumentException e) {
                System.out.println(PREFIX + e.getMessage());
            }
        }
    }

    private Lotto getWinningLotto() {
        while (true) {
            try {
                return new Lotto(parser.parseWinningNumber(inputView.inputWinningNumber()));
            } catch (IllegalArgumentException e) {
                System.out.println(PREFIX + e.getMessage());
            }
        }
    }

    private BonusNumber getBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                return new BonusNumber(parser.parseBonusNumber(inputView.inputBonusNumber()), winningLotto);
            } catch (IllegalArgumentException e) {
                System.out.println(PREFIX + e.getMessage());
            }
        }
    }
}
