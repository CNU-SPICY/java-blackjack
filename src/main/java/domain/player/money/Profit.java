package src.main.java.domain.player.money;

public class Profit {
    private int profit;

    public void earn(int earnedMoney) {
        profit += earnedMoney;
    }

    public void lose(int lostMoney) {
        profit -= lostMoney;
    }

    public int getProfit() {
        return profit;
    }
}
