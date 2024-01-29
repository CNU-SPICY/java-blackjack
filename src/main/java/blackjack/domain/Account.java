package blackjack.domain;

public class Account {

    private int betting = 0;
    private int profit = 0;

    public void addBetting(int betting) {
        this.betting += betting;
    }

    public int getBetting() {
        return betting;
    }

    public void addProfit(int money) {
        this.profit += money;
    }

    public int getProfit() {
        return profit;
    }
}