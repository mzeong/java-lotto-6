package lotto.view;

import static lotto.view.InputView.printMessage;
import static lotto.view.Message.OUTPUT_LOTTO_COUNT;
import static lotto.view.Message.OUTPUT_PROFITRATE;
import static lotto.view.Message.OUTPUT_RESULT;

import lotto.domain.Lottos;
import lotto.domain.Result;

public class OutputView {
    public void printLottoCount(final int count) {
        printFormattedMessage(OUTPUT_LOTTO_COUNT, count);
    }

    public void printLottos(Lottos lottos) {
        System.out.println(lottos);
    }

    public void printResult(Result result) {
        printMessage(OUTPUT_RESULT);
        System.out.println(result);
    }

    public void printProfitRate(double profitRate) {
        printFormattedMessage(OUTPUT_PROFITRATE, profitRate);
    }

    private void printFormattedMessage(Message message, int value) {
        System.out.println(message.getFormattedMessage(value));
    }

    private void printFormattedMessage(Message message, double value) {
        System.out.println(message.getFormattedMessage(value));
    }
}
