package src.main.java.dto;

import java.util.List;
import java.util.Map;

public class PlayerInfo {
    private String name;
    private Map<String, List<String>> handDetails;
    private int score;
    private int profit;

    public PlayerInfo(String name, Map<String, List<String>> handDetails, int score, int profit) {
        this.name = name;
        this.handDetails = handDetails;
        this.score = score;
        this.profit = profit;
    }

    public String getName() {
        return name;
    }

    public Map<String, List<String>> getHandDetails() {
        return handDetails;
    }

    public int getScore() {
        return score;
    }

    public int getProfit() {
        return profit;
    }
}
