package lotto.view;

import lotto.domain.Lottos;

public class OutputView {
    public void printLottos(int count, Lottos lottos) {
        System.out.printf("%d개를 구매했습니다.\n", count);
        System.out.println(lottos);
    }
}
