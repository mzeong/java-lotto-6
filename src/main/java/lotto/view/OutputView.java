package lotto.view;

import java.util.EnumMap;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Rank;

public class OutputView {
    public void printLottos(Money money, Lottos lottos) {
        System.out.printf("%d개를 구매했습니다.\n", money.getCount());
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printResult(EnumMap<Rank, Integer> result) {
        System.out.println("당첨 통계\n---");
        String collect = result.entrySet()
                .stream()
                .filter(entry -> entry.getKey() != Rank.OUT_OF_RANK)
                .map(entry -> entry.getKey().toString() + " - " + entry.getValue() + "개")
                .collect(Collectors.joining("\n"));
        System.out.println(collect);
    }

    public void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %,.1f%%입니다.", profitRate);
    }
}
