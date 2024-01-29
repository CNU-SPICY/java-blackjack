package src.main.java.domain.player.management;

import src.main.java.domain.player.money.BetMoney;
import src.main.java.domain.player.money.Profit;

public class MoneyManagement {
    private Profit profit;
    private BetMoney betMoney;

    public MoneyManagement() {
        this.profit = new Profit();
        this.betMoney = new BetMoney(0);
    }

    public void bet(int amount) {
        this.betMoney = new BetMoney(amount);
    }

    public void earn(int amount) {
        profit.earn(amount);
    }

    public void lose(int amount) {
        profit.lose(amount);
    }

    public int getProfit() {
        return profit.getProfit();
    }

    public int getBetMoney() {
        return betMoney.getAmount();
    }
}