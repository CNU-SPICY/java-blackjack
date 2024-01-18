package domain;

public class Score {

    private int winCount;
    private int drawCount;
    private int loseCount;

    public Score() {
        this.winCount = 0;
        this.drawCount = 0;
        this.loseCount = 0;
    }

    public void increaseWinCount() {
        winCount++;
    }

    public void increaseDrawCount() {
        drawCount++;
    }

    public void increaseLoseCout() {
        loseCount++;
    }
}
