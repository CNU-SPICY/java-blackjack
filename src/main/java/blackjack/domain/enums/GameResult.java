package blackjack.domain.enums;

public enum GameResult {

    WIN("승"),
    LOSE("패"),
    DRAW("무");

    private final String result;

    GameResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
