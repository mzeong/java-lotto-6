package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.util.RandomNumberGenerator;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int count, RandomNumberGenerator randomNumberGenerator) {
        this.lottos = IntStream.range(0, count)
                .mapToObj(i -> new Lotto(randomNumberGenerator.generate()))
                .toList();
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
