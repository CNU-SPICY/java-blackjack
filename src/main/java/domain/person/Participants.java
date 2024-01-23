package domain.person;

public class Participants {

    private final Players players;
    private final Dealer dealer;

    private Participants(Players players, Dealer dealer) {
        this.players = players;
        this.dealer = dealer;
    }

    public Participants create(final Players players, final Dealer dealer) {
        return new Participants(players, dealer);
    }
}
