package src.main.java.controller;

import src.main.java.domain.Dealer;
import src.main.java.domain.Player;
import src.main.java.domain.Players;
import src.main.java.view.InputView;
import src.main.java.view.OutputView;

public class GameController {
    public void run() {
        final var playersNames = InputView.getPlayersNames();
        final var players = new Players(playersNames);
        final var dealer = new Dealer();

        startGame(players, dealer);
        playPlayersRounds(players);
        playDealerTurn(players, dealer);
        determineWinners(players, dealer);
        displayResults(players, dealer);
    }

    private void startGame(Players players, Dealer dealer) {
        players.startGame(dealer);
        OutputView.displayInitialHands(players.getPlayersHands(), dealer.getFaceUpCard());
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
        OutputView.displayPlayerHand(player.getName(), player.handToString());
    }

    private void playDealerTurn(Players players, Dealer dealer) {
        players.playDealerTurn(dealer);
        if (dealer.isHasReceive()) {
            OutputView.displayDealerReceivedCard();
        }
    }

    private void displayResults(Players players, Dealer dealer) {
        OutputView.displayDealerResult(dealer.handToString(), dealer.calculateScore());
        for (Player player : players.getPlayers()) {
            OutputView.displayPlayerResult(player.getName(), player.handToString(), player.calculateScore());
        }
        displayFinalWins(players, dealer);
    }

    private void determineWinners(Players players, Dealer dealer) {
        for (Player player : players.getPlayers()) {
            players.determineWinners(player, dealer);
        }
    }

    private void displayFinalWins(Players players, Dealer dealer) {
        OutputView.displayDealerWins(dealer.getWins(), dealer.getLosses(), dealer.getDraws());
        for (Player player : players.getPlayers()) {
            OutputView.displayPlayerWins(player.getName(), player.getWins(), player.getLosses(), player.getDraws());
        }
    }
}