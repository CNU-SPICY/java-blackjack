package src.main.java.domain.player;

import src.main.java.domain.card.Card;
import src.main.java.domain.player.money.BetMoney;
import src.main.java.domain.player.money.Profit;
import src.main.java.domain.player.result.DrawCount;
import src.main.java.domain.player.result.LossCount;
import src.main.java.domain.player.result.WinCount;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Player {
    private String name;
    private List<Card> hand;
    private WinCount wins;
    private LossCount losses;
    private DrawCount draws;
    private Profit profit;
    private BetMoney betMoney;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.wins = new WinCount();
        this.losses = new LossCount();
        this.draws = new DrawCount();
        this.profit = new Profit();
        this.betMoney = new BetMoney(0);
    }

    public void bet(int stake) {
        this.betMoney = new BetMoney(stake);
    }

    public void receiveCard(Card card) {
        hand.add(card);
    }

    public List<Card> getHand() {
        return hand;
    }

    public Map<String, List<String>> getHandDetails() {
        Map<String, List<String>> handDetails = new LinkedHashMap<>();
        for (Card card : hand) {
            String suitName = card.getSuit().getName();
            handDetails.computeIfAbsent(suitName, k -> new ArrayList<>())
                    .add(card.getRank().toString());
        }
        return handDetails;
    }

    public int calculateScore() {
        int score = 0;
        int numAces = 0;

        for (Card card : hand) {
            score += card.getValue();
            if (card.getValue() == 1) {
                numAces++;
            }
        }
        while (numAces > 0 && score <= 11) {
            score += 10;
            numAces--;
        }
        return score;
    }

    public boolean isBlackJack() {
        return hand.size() == 2 && calculateScore() == 21;
    }

    public String getName() {
        return name;
    }

    public void incrementWins() {
        wins.increment();
    }

    public void incrementLosses() {
        losses.increment();
    }

    public void incrementDraws() {
        draws.increment();
    }

    public void earnMoney(int earnedMoney) { profit.earn(earnedMoney); }

    public void loseMoney(int lostMoney) { profit.lose(lostMoney); }

    public int getWins() {
        return wins.getCount();
    }

    public int getLosses() {
        return losses.getCount();
    }

    public int getDraws() {
        return draws.getCount();
    }

    public int getProfit() { return profit.getProfit(); }

    public int getBetMoney() { return betMoney.getAmount(); }
}