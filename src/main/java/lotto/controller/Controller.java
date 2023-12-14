package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Money;
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
        Money amount = getAmount();
        Lotto winningLotto = getWinningLotto();
        BonusNumber bonusNumber = getBonusNumber(winningLotto);
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

    //    public void run() {
//        List<Category> amount = getAmount();
////        List<Integer> integers = parser.parseComma("1,2, 3, 4, 5");
//        System.out.println(amount);
//        System.out.println(amount.size());
////        System.out.println();
////        Money money = getAmount();
////        int count = money.calculateCount();
////        Lottos lottos = new Lottos(new RandomGenerator(), count);
////        outputView.printLottos(count, lottos);
////
////        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
////        BonusNumber bonusNumber = new BonusNumber(7);
////
////        EnumMap<Rank, Integer> result = lottos.compareAll(winningLotto, bonusNumber);
////        int profit = Rank.calculateProfit(result);
////        double profitRate = money.calculateProfitRate(profit);
////        outputView.printResult(result);
////        outputView.printProfitRate(profitRate);
//    }
}
