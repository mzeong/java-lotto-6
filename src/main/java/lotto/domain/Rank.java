package lotto.domain;

import static lotto.view.Message.OUTPUT_RANK_MATCH_BONUS;
import static lotto.view.Message.OUTPUT_RANK_MATCH_COUNT;
import static lotto.view.Message.OUTPUT_RANK_PRIZE;

import java.util.Arrays;

public enum Rank {
    OUT_OF_RANK(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private static final Rank[] VALUES = values();
    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;

    Rank(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public static Rank calculateRank(int matchCount, boolean matchBonus) {
        return Arrays.stream(VALUES)
                .filter(rank -> rank.matchCount == matchCount && rank.matchBonus == matchBonus)
                .findFirst()
                .orElse(OUT_OF_RANK);
    }

    public int calculateTotalPrize(int value) {
        return this.prize * value;
    }

    @Override
    public String toString() {
        return toMatchCountString() + toMatchBonusString(this.matchBonus) + toPrizeString();
    }

    private String toMatchCountString() {
        return OUTPUT_RANK_MATCH_COUNT.getFormattedMessage(matchCount);
    }

    private String toMatchBonusString(boolean matchBonus) {
        if (matchBonus) {
            return OUTPUT_RANK_MATCH_BONUS.getMessage();
        }
        return "";
    }

    private String toPrizeString() {
        return OUTPUT_RANK_PRIZE.getFormattedMessage(prize);
    }
}
