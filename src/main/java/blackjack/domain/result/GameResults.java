package blackjack.domain.result;

import blackjack.domain.result.GameResult;
import java.util.ArrayList;
import java.util.List;

public class GameResults {

    private final List<GameResult> gameResults;

    public GameResults() {
        this.gameResults = new ArrayList<>();
    }

    public void addWin() {
        gameResults.add(GameResult.WIN);
    }

    public void addLose() {
        gameResults.add(GameResult.LOSE);
    }

    public void addDraw() {
        gameResults.add(GameResult.DRAW);
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