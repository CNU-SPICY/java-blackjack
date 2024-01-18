package blackjack.domain;

import blackjack.domain.validator.PlayerSizeValidator;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    public Players(List<String> playerNames) {
        PlayerSizeValidator.validate(playerNames);
        players = playerNames.stream()
                .map(Player::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Player> getPlayers() {
        return players;
    }
}
