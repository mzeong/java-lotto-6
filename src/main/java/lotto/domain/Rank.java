package lotto.domain;

public enum Rank {
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 30_000_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean isSame;
    private final int prize;

    Rank(int matchCount, boolean isSame, int prize) {
        this.matchCount = matchCount;
        this.isSame = isSame;
        this.prize = prize;
    }
}
