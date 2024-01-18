package blackjack.controller;

import blackjack.domain.Dealer;
import blackjack.domain.Deck;
import blackjack.domain.Player;
import blackjack.domain.Players;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.List;

public class BlackjackController {

    InputView inputView;
    OutputView outputView;
    Deck deck;
    Dealer dealer;
    Players players;

    public void run() {
        inputView = new InputView();
        outputView = new OutputView();
        deck = new Deck();
        dealer = new Dealer(deck);

        List<String> playerNames = inputView.getPlayerNames();
        players = new Players(playerNames);

        allReceivedCard();
        outputView.printStatusOfAll(dealer, players);
        players.getPlayers().forEach(this::askPickCard);
        inputView.close();
        handleDealerCard();

        outputView.printFinalStatusOfAll(dealer, players);
        decideResultOfAll();
    }

    private void allReceivedCard() {
        dealer.giveInitialCard(players);
        outputView.allReceivedCard(dealer, players);
    }

    private void askPickCard(Player player) {
        boolean response = true;
        while (player.canPickCard() && response) {
            response = processAskPickCard(player);
            outputView.printStatus(player);
        }
    }

    private boolean processAskPickCard(Player player) {
        boolean response = inputView.getResponseWantCard(player);
        if (response) {
            response = dealer.giveCardToPlayer(player);
        }
        return response;
    }

    private void handleDealerCard() {
        if (dealer.giveCardToPlayer(dealer)) {
            outputView.dealerReceivedCard(dealer);
        }
    }

    private void decideResultOfAll() {
        dealer.decideResultOfAll(players);
        outputView.printResult(dealer, players);
    }
}
