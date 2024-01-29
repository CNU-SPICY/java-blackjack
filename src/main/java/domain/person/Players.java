package domain.person;

import dto.PlayerDto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    private Players(final List<String> playerNames) {
        players = playerNames.stream()
                .map(Player::create)
                .collect(Collectors.toList());
    }

    public static Players create(final List<String> playerNames) {
        return new Players(playerNames);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<PlayerDto> getPlayersDto() {
        List<PlayerDto> allPlayersInfo = new ArrayList<>();
        for (Player player : players) {
            allPlayersInfo.add(player.getPlayerInfo());
        }
        return allPlayersInfo;
    }
}
