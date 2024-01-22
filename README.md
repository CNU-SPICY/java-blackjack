# java-blackjack

블랙잭 미션 저장소

## View 
#### InputView 
- 게임에 참여할 사람과, 해당 플레이어에게 카드 한장을 더 받을 건지에 대한 여부를 입력받는다.
#### OutputView
- 플레이어들과 딜러의 카드 상태와, 점수 및 승패를 출력하는 로직을 담당한다.   

## Domain
#### Card
- 각 카드에 대한 정보를 처리하고, 덱을 만드는 역할을 한다.
> getValue(): 해당 카드에 대한 값을 정수로 반환한다.   
> toString() : 해당 카드의 rank와 suit를 하나의 문자열로 반환한다.   
> initializeDeck() : 카드를 섞어서, 하나의 새로운 덱을 Card의 타입을 가지는 리스트로 반환한다.

#### Player
- 플레이어의 이름과 손에 든 카드, 승리, 패배, 동점 점수를 인스턴스 변수로 가지며, 손에 든 카드와 점수를 관리한다.
> receiveCard(Card card) : 플레이어의 손에 카드를 더한다.   
> handToString() : 플레이어의 손에 든 카드를 문자열로 반환한다.   
> calculateScore() : 플레이어의 손에 든 카드의 점수를 정수로 반환한다. 이때 에이스의 점수를 1로 할 것인지 11로 할 것인지에 관한 여부도 함께 판단한다.   
> increment : 각 승리, 패배, 동점 점수를 올린다.

#### Players
- 플레이어들과 덱 한 뭉치를 인스턴스 변수로 가진다. 플레이어들이 모여 게임을 할 때 필요한 로직을 담당한다.
> drawCard() : 덱 한 뭉치의 가장 첫 번째 카드를 빼서 반환한다.   
> startGame() : 게임을 시작한다. 각 플레이어들과 딜러에게 각각 2장씩 카드를 건네준다.   
> getPlayersHands() : 플레이어들의 이름과 가지고 있는 카드들을 Map의 타입으로 반환한다.
> playPlayerTurn(Player player) : 해당 플레이어에게 카드 한 장을 준다.   
> playDealerTurn(Dealer dealer) : 딜러에게 카드 한 장을 준다. 이때, 딜러가 카드 한 장을 받았다고 표식한다.   
> determineWinners(Player player, Dealer dealer) : 플레이어와 딜러의 카드의 점수를 비교해 승리, 패배, 동점 점수를 올린다.

## Controller
#### GameController
- 블랙잭 게임을 진행하는 곳이며, 플레이어와 딜러가 가진 정보를 OutputView에 전달하는 로직을 담당한다.

#### 
## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)
