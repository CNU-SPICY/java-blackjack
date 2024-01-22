package src.main.java.domain.player.result;

public class WinCount {
    private int count;

    public WinCount() {
        this.count = 0;
    }

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}