package lotto.domain;

public enum Rank {
    OUT_OF_RANK(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean hasMatched;
    private final int prize;

    Rank(int matchCount, boolean hasMatched, int prize) {
        this.matchCount = matchCount;
        this.hasMatched = hasMatched;
        this.prize = prize;
    }

    @Override
    public String toString() {
        return toMatchCountString() + toHasMatchedString() + toPrizeString();
    }

    private String toMatchCountString() {
        return String.format("%d개 일치", matchCount);
    }

    private String toHasMatchedString() {
        if (hasMatched) {
            return ", 보너스 볼 일치";
        }
        return "";
    }

    private String toPrizeString() {
        return String.format(" (%,d원)", prize);
    }
}
