package view;

import domain.Dealer;
import domain.Person;
import domain.Player;
import domain.Players;

public class OutputView {

    public static void showPlayersCards(Dealer dealer, Players players) {
        showPersonCard(dealer);

        for (Player player : players.getPlayers()) {
            showPersonCard(player);
        }
    }

    public static void showPersonCard(Person person) {

    }
}
