package view;

import domain.Card;
import domain.Dealer;
import domain.Person;
import domain.Player;
import domain.Players;
import java.util.List;

public class OutputView {

    public static void showDividePlayerCards(Dealer dealer, Players players) {
        System.out.println("딜러와 pobi, jason에게 2장을 나누었습니다.");
        showPlayersCards(dealer, players);
    }

    public static void showPlayersCards(Dealer dealer, Players players) {
        showPersonCard(dealer);

        for (Player player : players.getPlayers()) {
            showPersonCard(player);
        }
    }

    public static void showPersonCard(Person person) {
        StringBuilder personCards = new StringBuilder();
        personCards.append(person.getName()).append(": ");
        List<Card> ownCards = person.getOwnCards();

        ownCards.forEach(card -> personCards.append(card.getCardFullName()).append(" "));
        System.out.println(personCards.toString());
    }
}
