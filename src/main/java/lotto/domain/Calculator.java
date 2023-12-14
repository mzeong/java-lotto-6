package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;

public class Calculator {
    private final Lottos lottos;
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;
    private final Money money;

    public Calculator(Lottos lottos, Lotto winningLotto, BonusNumber bonusNumber, Money money) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        this.money = money;
    }

    public EnumMap<Rank, Integer> calculateResult() {
        EnumMap<Rank, Integer> result = new EnumMap<>(Rank.class);
        Arrays.stream(Rank.VALUES)
                .forEach(rank -> result.put(rank, 0));

        for (Lotto lotto : lottos.getLottos()) {
            int matchCount = getMatchCount(lotto);
            boolean hasMatched = getHasMatched();
            Rank rank = getRank(matchCount, hasMatched);
            result.put(rank, result.get(rank) + 1);
        }
        return result;
    }

    private int getMatchCount(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(number -> winningLotto.getNumbers().contains(number))
                .count();
    }

    private boolean getHasMatched() {
        return winningLotto.getNumbers().contains(bonusNumber);
    }

    private Rank getRank(int matchCount, boolean hasMatched) {
        return Arrays.stream(Rank.VALUES)
                .filter(rank -> rank.getMatchCount() == matchCount && rank.isHasMatched() == hasMatched)
                .findFirst()
                .orElse(Rank.OUT_OF_RANK);
    }
    public Double calculateProfitRate() {
        return 1.1;
    }
}
