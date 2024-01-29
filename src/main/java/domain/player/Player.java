package src.main.java.domain.player;

import src.main.java.domain.card.Card;
import src.main.java.domain.player.management.CardManagement;
import src.main.java.domain.player.management.MoneyManagement;
import src.main.java.domain.player.management.ResultManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Player {
    private final String name;
    private CardManagement cardManagement;
    private ResultManagement resultManagement;
    private MoneyManagement moneyManagement;

    public Player(String name) {
        this.name = name;
        this.cardManagement = new CardManagement();
        this.resultManagement = new ResultManagement();
        this.moneyManagement = new MoneyManagement();
    }

    public void receiveCard(Card card) {
        cardManagement.receiveCard(card);
    }

    public Map<String, List<String>> getHandDetails() {
        return cardManagement.getHandDetails();
    }

    public List<Card> getHand() {
        return cardManagement.getHand();
    }

    public int calculateScore() {
        return cardManagement.calculateScore();
    }

    public boolean isBlackJack() {
        return cardManagement.isBlackJack();
    }

    public void bet(int amount) {
        moneyManagement.bet(amount);
    }

    public void earnMoney(int amount) {
        moneyManagement.earn(amount);
    }

    public void loseMoney(int amount) {
        moneyManagement.lose(amount);
    }

    public int getBetMoney() {
        return moneyManagement.getBetMoney();
    }

    public int getProfit() {
        return moneyManagement.getProfit();
    }

    public void incrementWins() {
        resultManagement.incrementWins();
    }

    public void incrementLosses() {
        resultManagement.incrementLosses();
    }

    public void incrementDraws() {
        resultManagement.incrementDraws();
    }

    public int getWins() {
        return resultManagement.getWins();
    }

    public int getLosses() {
        return resultManagement.getLosses();
    }

    public int getDraws() {
        return resultManagement.getDraws();
    }

    public String getName() {
        return name;
    }
}
