package blackjack.domain;

import blackjack.domain.enums.GameResult;
import java.util.ArrayList;
import java.util.List;

public class GameResults {

    private final List<GameResult> gameResults;

    public GameResults() {
        this.gameResults = new ArrayList<>();
    }

    public void decideResultOfAll(Dealer dealer, Players players) {
        players.getPlayers().forEach(player -> {
            decideResult(dealer, player);
        });
    }

    private void decideResult(Dealer dealer, Player player) {
        int result = compareScore(dealer, player);
        if (result > 0) {
            gameResults.add(GameResult.WIN);
            player.setResultToLose();
            return;
        }
        if (result < 0) {
            gameResults.add(GameResult.LOSE);
            player.setResultToWin();
            return;
        }
        gameResults.add(GameResult.DRAW);
        player.setResultToDraw();
    }

    private int compareScore(Dealer dealer, Player player) {
        if (player.isBust()) {
            return 1;
        }
        if (dealer.isBust()) {
            return -1;
        }
        return dealer.getScore() - player.getScore();
    }

    public int getWinCount() {
        return (int) gameResults.stream().filter(gameResult -> gameResult == GameResult.WIN).count();
    }

    public int getLoseCount() {
        return (int) gameResults.stream().filter(gameResult -> gameResult == GameResult.LOSE).count();
    }

    public int getDrawCount() {
        return (int) gameResults.stream().filter(gameResult -> gameResult == GameResult.DRAW).count();
    }

    public List<GameResult> getGameResults() {
        return gameResults;
    }
}
