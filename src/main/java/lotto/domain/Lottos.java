package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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

//    public EnumMap<Rank, Integer> compareAll(Lotto winningLotto, BonusNumber bonusNumber) {
//        EnumMap<Rank, Integer> result = new EnumMap<>(Rank.class);
//        Arrays.stream(Rank.values())
//                .forEach(rank -> result.put(rank, 0));
//
//        for (Lotto lotto : lottos) {
//            int matchCount = lotto.compare(winningLotto);
//            boolean hasMatched = lotto.compare(bonusNumber);
//            Rank rank = Rank.findRank(matchCount, hasMatched);
//            result.put(rank, result.get(rank) + 1);
//        }
//        return result;
//    }
//
//    @Override
//    public String toString() {
//        return lottos.stream()
//                .map(Lotto::toString)
//                .collect(Collectors.joining("\n"));
//    }
}
