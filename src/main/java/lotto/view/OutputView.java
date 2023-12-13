package lotto.view;

import static lotto.view.Message.OUTPUT_LOTTO_COUNT;

import lotto.domain.Lottos;

public class OutputView {
    public void printLottoCount(final int count) {
        printFormattedMessage(OUTPUT_LOTTO_COUNT, count);
    }

    public void printLottos(Lottos lottos) {
        System.out.println(lottos);
    }

    private void printFormattedMessage(Message message, int count) {
        System.out.println(message.getFormattedMessage(count));
    }
}
