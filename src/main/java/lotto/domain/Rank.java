package lotto.domain;

public enum Rank {
    OUT_OF_RANK(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    public static final Rank[] VALUES = values();
    private final int matchCount;
    private final boolean hasMatched;
    private final int prize;

    Rank(int matchCount, boolean hasMatched, int prize) {
        this.matchCount = matchCount;
        this.hasMatched = hasMatched;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isHasMatched() {
        return hasMatched;
    }

    public int getPrize() {
        return prize;
    }
}
