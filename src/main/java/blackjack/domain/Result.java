package blackjack.domain;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private final Map<String, Integer> playerAmounts = new HashMap<>();
    private int dealerAmount = 0;

    public void addBetAmount(String name, int betAmount) {
        playerAmounts.put(name, betAmount);
    }

    public void updateBetAmount(String name, String result) {
        int amount = playerAmounts.get(name);
        if(result == GameConstant.WIN) {
            dealerAmount -= amount;
            return;
        }
        if(result == GameConstant.LOSE) {
            dealerAmount += amount;
            playerAmounts.put(name, -amount);
            return;
        }
        if(result == GameConstant.BLACKJACK) {
            int blackjackAmount =  (int) (amount * GameConstant.BLACKJACK_ODDS);
            dealerAmount -= blackjackAmount;
            playerAmounts.put(name, blackjackAmount);
            return;
        }
        playerAmounts.put(name, 0);
    }

    public int getDealerAmount() {
        return dealerAmount;
    }

    public Map<String, Integer> getPlayerResults() {
        return playerAmounts;
    }
}