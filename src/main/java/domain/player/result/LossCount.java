package src.main.java.domain.player.result;

public class LossCount {
    private int count;

    public LossCount() {
        this.count = 0;
    }

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
