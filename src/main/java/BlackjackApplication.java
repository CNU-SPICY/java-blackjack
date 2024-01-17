import controller.BlackjackController;
import java.io.IOException;
import view.InputView;

public class BlackjackApplication {

    public static void main(final String... args) throws IOException {
        final var playerNames = InputView.inputPlayerNames();

        BlackjackController blackjackController = new BlackjackController(playerNames);
        blackjackController.start();
    }
}