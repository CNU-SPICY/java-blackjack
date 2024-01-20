package src.main.java.domain.card;

public class Rank {
    private final String rank;

    public Rank(String rank) {
        validateRank(rank);
        this.rank = rank;
    }

    private void validateRank(String rank) {
        if (!isValidRank(rank)) {
            throw new IllegalArgumentException("Invalid card rank: " + rank);
        }
    }

    private boolean isValidRank(String rank) {
        return rank.matches("[2-9]|10|A|K|Q|J");
    }

    @Override
    public String toString() {
        return rank;
    }
}
