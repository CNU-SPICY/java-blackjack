package blackjack.domain;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private int dealerWinCount = 0;
    private int dealerPushCount = 0;
    private int dealerLoseCount = 0;
    private Map<String, String> playerResults = new HashMap<>();
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

    public void addPlayerResult(String name, String result) {
        playerResults.put(name, result);
        if(result == "승") {
            dealerLoseCount ++;
            return;
        }
        if(result == "패") {
            dealerWinCount ++;
            return;
        }
        dealerPushCount ++;
    }


}
