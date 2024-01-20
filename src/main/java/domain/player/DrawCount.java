package src.main.java.domain.player;

public class DrawCount {
    private int count;

    public DrawCount() {
        this.count = 0;
    }

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}