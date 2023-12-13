package lotto.domain;

import static lotto.domain.Rank.calculateRank;

import java.util.Arrays;
import java.util.EnumMap;
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

    public EnumMap<Rank, Integer> calculateResult(Lotto winningNumber, BonusNumber bonusNumber) {
        EnumMap<Rank, Integer> result = new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values())
                .forEach(rank -> result.put(rank, 0));

        lottos.stream()
                .map(lotto -> {
                    int matchCount = lotto.calculateMatchCount(winningNumber);
                    boolean matchBonus = lotto.hasMatched(bonusNumber);
                    return calculateRank(matchCount, matchBonus);
                })
                .forEach(rank -> result.put(rank, result.get(rank) + 1));
        return result;
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
