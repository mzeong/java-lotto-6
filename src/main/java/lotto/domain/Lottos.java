package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;
import lotto.util.RandomNumberGenerator;

public class Lottos {
    private final Amount amount;
    private final RandomNumberGenerator randomNumberGenerator;
    private final List<Lotto> lottos;

    public Lottos(Amount amount, RandomNumberGenerator randomNumberGenerator) {
        this.amount = amount;
        this.randomNumberGenerator = randomNumberGenerator;
        this.lottos = createLottos();
    }

    private List<Lotto> createLottos() {
        return IntStream.range(0, amount.calculateLottoCount())
                .mapToObj(i -> new Lotto(randomNumberGenerator.generate()))
                .toList();
    }
}
