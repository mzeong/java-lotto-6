package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;
import lotto.util.RandomGenerator;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(RandomGenerator randomGenerator, Money money) {
        this.lottos = IntStream.range(0, money.getCount())
                .mapToObj(i -> new Lotto(randomGenerator.generate()))
                .toList();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
