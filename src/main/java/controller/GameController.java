package src.main.java.controller;

import src.main.java.domain.player.Dealer;
import src.main.java.domain.player.Player;
import src.main.java.domain.players.Players;
import src.main.java.view.InputView;
import src.main.java.view.OutputView;

public class GameController {
    public void run() {
        final var playersNames = InputView.getPlayersNames();
        final var players = new Players(playersNames);
        final var dealer = new Dealer();

        startBet(players);
        startGame(players, dealer);
        playPlayersRounds(players);
        playDealerTurn(players, dealer);
        determineWinners(players, dealer);
        displayResults(players, dealer);
    }

    private void startBet(Players players) {
        for (Player player : players.getPlayers()) {
            int betMoney = InputView.askStake(player.getName());
            player.bet(betMoney);
        }
    }

    private void startGame(Players players, Dealer dealer) {
        players.startGame(dealer);
        OutputView.displaySharedTwoCards(players.getPlayersNames());
        OutputView.displayDealerHand(dealer.getFaceUpCard());
        for (Player player : players.getPlayers()) {
            String cardsOfPlayer = OutputView.formatCards(player.getHandDetails());
            OutputView.displayPlayerHand(player.getName(), cardsOfPlayer);
        }
    }

    private void playPlayersRounds(Players players) {
        for (Player player : players.getPlayers()) {
            playPlayersRound(player, players);
        }
    }

    private void playPlayersRound(Player player, Players players) {
        while (shouldContinue(player)) {
            playSingleTurn(player, players);
        }
    }

    private boolean shouldContinue(Player player) {
        return InputView.askGetMore(player.getName());
    }

    private void playSingleTurn(Player player, Players players) {
        players.playPlayerTurn(player);
        String cardsInHand = OutputView.formatCards(player.getHandDetails());
        OutputView.displayPlayerHand(player.getName(), cardsInHand);
    }

    private void playDealerTurn(Players players, Dealer dealer) {
        players.playDealerTurn(dealer);
        if (dealer.isHasReceive()) {
            OutputView.displayDealerReceivedCard();
        }
    }

    private void displayResults(Players players, Dealer dealer) {
        String cardsOfDealer = OutputView.formatCards(dealer.getHandDetails());
        OutputView.displayDealerResult(cardsOfDealer, dealer.calculateScore());
        for (Player player : players.getPlayers()) {
            String cardsOfPlayer = OutputView.formatCards(player.getHandDetails());
            OutputView.displayPlayerResult(player.getName(), cardsOfPlayer, player.calculateScore());
        }
        displayFinalWins(players, dealer);
    }

    private void determineWinners(Players players, Dealer dealer) {
        players.determineWinners(dealer);
    }

    private void displayFinalWins(Players players, Dealer dealer) {
        OutputView.displayDealerGain(dealer.getProfit());;
        for (Player player : players.getPlayers()) {
            OutputView.displayPlayerGain(player.getName(), player.getProfit());
        }
    }
}