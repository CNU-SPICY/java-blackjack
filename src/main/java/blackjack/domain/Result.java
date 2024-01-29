package blackjack.domain;

import blackjack.domain.person.Name;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Result {
    private final Map<Name, Integer> playerAmounts = new HashMap<>();
    private int dealerAmount = 0;

    public void addBetAmount(Name name, int betAmount) {
        playerAmounts.put(name, betAmount);
    }

    public void updateBetAmount(Name name, String result) {
        int playerAmount = playerAmounts.get(name);
        if(Objects.equals(result, GameConstant.WIN)) {
            dealerAmount -= playerAmount;
            return;
        }
        if(Objects.equals(result, GameConstant.LOSE)) {
            dealerAmount += playerAmount;
            playerAmounts.put(name, -playerAmount);
            return;
        }
        if(Objects.equals(result, GameConstant.BLACKJACK)) {
            int blackjackAmount =  (int) (playerAmount * GameConstant.BLACKJACK_ODDS);
            dealerAmount -= blackjackAmount;
            playerAmounts.put(name, blackjackAmount);
            return;
        }
        playerAmounts.put(name, 0);
    }

    public int getDealerAmount() {
        return dealerAmount;
    }

    public Map<Name, Integer> getPlayerResults() {
        return playerAmounts;
    }
}