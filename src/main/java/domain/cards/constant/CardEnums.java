package domain.cards.constant;

public class CardEnums {
    public enum CardSuit {
        DIAMOND("다이아몬드"),
        HEART("하트"),
        SPADE("스페이드"),
        CLOBA("클로버");

        private final String suitName;

        CardSuit(String suitName) {
            this.suitName = suitName;
        }

        public String getSuitName() {
            return suitName;
        }
    }

    public enum CardRank {
        A("A"),
        TWO("2"),
        THREE("3"),
        FOUR("4"),
        FIVE("5"),
        SIX("6"),
        SEVEN("7"),
        EIGHT("8"),
        NINE("9"),
        TEN("10"),
        J("J"),
        Q("Q"),
        K("K");

        private final String rankName;

        CardRank(String rankName) {
            this.rankName = rankName;
        }

        public String getRankName() {
            return rankName;
        }
    }
}
