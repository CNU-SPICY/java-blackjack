package domain.person;

import domain.person.wrapper.NameWrapper;
import dto.PlayerInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    public Players(List<String> playerNames) {
        players = playerNames.stream()
                .map(playerName -> new Player(new NameWrapper(playerName)))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<PlayerInfo> getPlayersInfo() {
        List<PlayerInfo> allPlayersInfo = new ArrayList<>();
        for (Player player : players) {
            allPlayersInfo.add(player.getPlayerInfo());
        }
        return allPlayersInfo;
    }
}
