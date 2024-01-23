package blackjack.controller;

import blackjack.domain.Dealer;
import blackjack.domain.card.Deck;
import blackjack.domain.Player;
import blackjack.domain.Players;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.List;

public class BlackjackController {

    public void run() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Deck deck = new Deck();
        Dealer dealer = new Dealer(deck);
        Players players;

        List<String> playerNames = inputView.getPlayerNames();
        players = new Players(playerNames);
        players.getPlayers().forEach(player -> doBetting(inputView, player));

        allReceivedCard(outputView, dealer, players);
        outputView.printStatusOfAll(dealer, players);
        players.getPlayers().forEach(player -> askHitCard(inputView, outputView, dealer, player));
        inputView.close();
        outputView.printLine();
        handleDealerCard(outputView, dealer);

        outputView.printFinalStatusOfAll(dealer, players);
        decideResultOfAll(outputView, dealer, players);
    }

    private void doBetting(InputView inputView, Player player) {
        int betting = inputView.getBettingValue(player);
        player.addBetting(betting);
    }

    private void allReceivedCard(OutputView outputView, Dealer dealer, Players players) {
        dealer.giveInitialCard(players);
        outputView.allReceivedCard(dealer, players);
    }

    private void askHitCard(InputView inputView, OutputView outputView, Dealer dealer, Player player) {
        boolean response = true;
        while (player.isHittable() && response) {
            response = processAskPickCard(inputView, dealer, player);
            outputView.printStatus(player);
        }
    }

    private boolean processAskPickCard(InputView inputView, Dealer dealer, Player player) {
        boolean hitResponseOfPlayer = inputView.getResponseWantCard(player);
        if (hitResponseOfPlayer) {
            hitResponseOfPlayer = dealer.giveCardToPlayer(player);
        }
        return hitResponseOfPlayer;
    }

    private void handleDealerCard(OutputView outputView, Dealer dealer) {
        while (dealer.giveCardToPlayer(dealer)) {
            outputView.dealerReceivedCard(dealer);
        }
    }

    private void decideResultOfAll(OutputView outputView, Dealer dealer, Players players) {
        dealer.decideResultAll(players);
        outputView.printResult(dealer, players);
    }
}