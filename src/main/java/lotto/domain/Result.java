package lotto.domain;

import static lotto.view.Message.OUTPUT_RANK_LOTTO_COUNT;

import java.util.EnumMap;
import java.util.stream.Collectors;

public class Result {
    public static final String DELIMITER = "\n";
    private final EnumMap<Rank, Integer> result;

    public Result(Lottos lottos, Lotto winningLotto, BonusNumber bonusNumber) {
        this.result = lottos.calculateResult(winningLotto, bonusNumber);
    }

    public int calculateProfit() {
        return result.entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().calculateTotalPrize(entry.getValue()))
                .sum();
    }

    @Override
    public String toString() {
        return result.entrySet()
                .stream()
                .filter(entry -> entry.getKey() != Rank.OUT_OF_RANK)
                .map(entry -> entry.getKey().toString() + OUTPUT_RANK_LOTTO_COUNT.getFormattedMessage(entry.getValue()))
                .collect(Collectors.joining(DELIMITER));
    }
}
