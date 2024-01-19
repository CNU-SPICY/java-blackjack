package src.main.java.domain;

public class Dealer extends Player {

    private boolean hasReceive = false;

    public Dealer() {
        super("딜러");
    }

    public String getFaceUpCard() {
        if (getHand().size() != 0) {
            Card faceUpCard = getHand().get(0);
            return faceUpCard.toString();
        } return null;
    }

    public boolean dealerShouldReceiveCard() {
        if (isHasReceive() == false && calculateScore() <= 16) {
            return true;
        }
        return false;
    }

    public void dealerReceivedCard() {
        hasReceive = true;
    }

    public boolean isHasReceive() {
        return hasReceive;
    }
}