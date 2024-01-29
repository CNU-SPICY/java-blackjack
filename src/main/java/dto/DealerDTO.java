package src.main.java.dto;

import java.util.Map;
import java.util.List;

public class DealerDTO {
    private Map<String, List<String>> handDetails;
    private int score;
    private int profit;

    public DealerDTO(Map<String, List<String>> handDetails, int score, int profit) {
        this.handDetails = handDetails;
        this.score = score;
        this.profit = profit;
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
