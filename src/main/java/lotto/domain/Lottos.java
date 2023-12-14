package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.util.RandomGenerator;

public class Lottos {
    private final RandomGenerator randomGenerator;
    private final List<Lotto> lottos;

    public Lottos(RandomGenerator randomGenerator, int count) {
        this.randomGenerator = randomGenerator;
        this.lottos = IntStream.range(0, count)
                .mapToObj(i -> new Lotto(randomGenerator.generate()))
                .toList();
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
