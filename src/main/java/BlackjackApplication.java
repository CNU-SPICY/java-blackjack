import controller.BlackjackController;
import java.io.IOException;

public class BlackjackApplication {

    public static void main(final String... args) throws IOException {
        BlackjackController blackjackController = new BlackjackController();
        blackjackController.start();
    }
}