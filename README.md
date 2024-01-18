# java-blackjack

블랙잭 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 코드 구성

- controller
    - InputView에서 받은 입력을 통해 Dealer와 Player를 생성
    - Player 당, 카드를 더 받을 지 InputView를 통해 받음
- View
    - Input View
        - Player 이름을 받고, 리스트 리턴
        - Player 마다 카드를 더 받을 지 물음
    - Output View
        - Dealer와 Player가 가진 카드 출력
- Domain
    - Dealer
        - 책임 : 각각의 Player와 맞짱 떠야 한다. 카드 합을 더하도록 시킨다.
    - Player
        - 책임 : 카드를 더 받을 지 안 받을 지 정하고, 추가/스탑해야 한다. 카드 합을 더하도록 시킨다.
    - Deck
        - 책임 : 모든 카드들을 보관한다.
    - OwnCards
        - 책임 : Person 마다 가지고 있는 카드를 지닌다. 합을 더하는 로직을 정해야 한다.
    - Card
        - 책임 : Card의 종류와 숫자를 가지고 있는다.
    - Players
        - 책임 : Player들을 전부 가지고 있는다.(불변 객체)
    - WinnerLogic
        - 책임 : ACE가 지닌 카드의 1 또는 11의 여부를 정해야 한다. 비교하는 로직을 가진다.
    - Score
        - 책임 : 승, 패, 무에 관련된 정보를 알고 있다. 승, 패, 무를 기록하는 책임을 지닌다.