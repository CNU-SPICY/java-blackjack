package src.main.java.domain.player.result;

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

    public static class LossCount {
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

    public static class WinCount {
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
}