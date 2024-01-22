package domain.logics;

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

    public int getWinCount() {
        return winCount;
    }

    public int getDrawCount() {
        return drawCount;
    }

    public int getLoseCount() {
        return loseCount;
    }
}
