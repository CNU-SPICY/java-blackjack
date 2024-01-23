package blackjack.domain;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private final Map<String, String> playerResults = new HashMap<>();
    private int dealerWinCount = 0;
    private int dealerPushCount = 0;
    private int dealerLoseCount = 0;

    public void addPlayerResult(String name, String result) {
        playerResults.put(name, result);
        if(result == GameConstant.WIN) {
            dealerLoseCount ++;
            return;
        }
        if(result == GameConstant.LOSE) {
            dealerWinCount ++;
            return;
        }
        dealerPushCount ++;
    }

    public int getDealerWinCount() {
        return dealerWinCount;
    }

    public int getDealerPushCount() {
        return dealerPushCount;
    }

    public int getDealerLoseCount() {
        return dealerLoseCount;
    }

    public Map<String, String> getPlayerResults() {
        return playerResults;
    }
}
