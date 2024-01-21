package blackjack.domain.card;

public enum CardType {

    CLOVER("클로버", 0),
    HEART("하트", 1),
    DIAMOND("다이아몬드", 2),
    SPADE("스페이드", 3);

    final private String name;
    final private int priority;

    CardType(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }
}
