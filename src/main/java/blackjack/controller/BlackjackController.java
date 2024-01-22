package blackjack.controller;

import blackjack.domain.Dealer;
import blackjack.domain.card.Deck;
import blackjack.domain.Player;
import blackjack.domain.Players;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.List;

public class BlackjackController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Deck deck = new Deck();
    Dealer dealer = new Dealer(deck);
    Players players;

    public void run() {
        List<String> playerNames = inputView.getPlayerNames();
        players = new Players(playerNames);
        players.getPlayers().forEach(this::doBetting);

        allReceivedCard();
        outputView.printStatusOfAll(dealer, players);
        players.getPlayers().forEach(this::askHitCard);
        inputView.close();
        outputView.printLine();
        handleDealerCard();

        outputView.printFinalStatusOfAll(dealer, players);
        decideResultOfAll();
    }

    private void doBetting(Player player) {
        int betting = inputView.getBettingValue(player);
        player.addBetting(betting);
    }

    private void allReceivedCard() {
        dealer.giveInitialCard(players);
        outputView.allReceivedCard(dealer, players);
    }

    private void askHitCard(Player player) {
        boolean response = true;
        while (player.isHittable() && response) {
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
        while (dealer.giveCardToPlayer(dealer)) {
            outputView.dealerReceivedCard(dealer);
        }
    }

    private void decideResultOfAll() {
        dealer.decideResultAll(players);
        outputView.printResult(dealer, players);
    }
}