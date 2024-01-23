package blackjack.domain;

public class CardData {
    public enum Denomination {
        ACE("A", 11),
        TWO("2", 2),
        THREE("3", 3),
        FOUR("4", 4),
        FIVE("5", 5),
        SIX("6", 6),
        SEVEN("7", 7),
        EIGHT("8", 8),
        NINE("9", 9),
        TEN("10", 10),
        JACK("J", 10),
        QUEEN("Q", 10),
        KING("K", 10);

        private final String denomination;
        private final int score;

        Denomination(String denomination, int score) {
            this.denomination = denomination;
            this.score = score;
        }

        public String getDenomination() {
            return denomination;
        }

        public int getScore() {
            return score;
        }
    }

    public enum Suit {
        SPADE("스페이드"),
        HEART("하트"),
        DIAMOND("다이아몬드"),
        CLUB("클로버");

        private final String suit;

        Suit(String suit) {
            this.suit = suit;
        }

        public String getSuit() {
            return suit;
        }
    }
}
