package lotto;

import lotto.controller.Controller;
import lotto.controller.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new InputView(), new OutputView(), new Parser());
        controller.run();
    }
}
