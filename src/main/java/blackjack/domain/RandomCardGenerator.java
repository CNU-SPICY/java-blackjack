package blackjack.domain;

import java.util.ArrayList;
import java.util.Random;
public class RandomCardGenerator {
    private static final int DIVIDE_NUMBER = 13;
    private final Random random = new Random();
    private CardData cardData = new CardData();
    private final ArrayList<Integer> drawnCards = new ArrayList<>();

    //0~51의 숫자에 각 카드를 할당
    //0~12 스페이드 / 13~25 다이아 / 26~38 하트 / 39~51 클로버 / A~K순
    //13으로 나눈 몫 : 문양, 나머지 : 숫자 혹은 알파벳
    public Card drawRandomCard() {
        int cardIndex;
        do {
            cardIndex = random.nextInt(52);
        }
        while(isDrawn(cardIndex));
        drawnCards.add(cardIndex);
        return indexToCard(cardIndex);
    }

    public boolean isDrawn(int cardIndex) {
        return drawnCards.contains(cardIndex);
    }

    public Card indexToCard(int cardIndex) {
        String cardInfo = indexToInfo(cardIndex);
        int cardScore = cardData.indexToScore(cardIndex % DIVIDE_NUMBER);
        return new Card(cardInfo, cardScore);
    }

    public String indexToInfo(int cardIndex) {
        String cardDenomination = cardData.indexToDenomination(cardIndex % DIVIDE_NUMBER);
        String cardSuit = cardData.indexToSuit(cardIndex / DIVIDE_NUMBER);
        return cardDenomination + cardSuit;
    }
}
