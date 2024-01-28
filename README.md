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

#### Player
- 플레이어의 이름과 손에 든 카드, 승리, 패배, 동점 점수 및 베팅 금액과 수익를 인스턴스 변수로 가지며, 손에 든 카드와 점수 및 수익을 관리한다.

#### Players
- 플레이어들과 덱 한 뭉치를 인스턴스 변수로 가진다. 플레이어들이 모여 게임을 할 때 필요한 로직을 담당한다.

#### WinLogic
- 플레이어가 이겼을 때, 딜러가 이겼을 때, 동점인 경우의 각 플레이어들과 딜러의 점수와 수익을 관리한다.

## DTO
## PlayerInfo
- 플레이어의 이름, 손패, 점수, 수익을 담는 DTO이다.

## DealerInfo
- 딜러의 손패, 점수, 수익을 담는 DTO이다.

## Controller
#### GameController
- 블랙잭 게임을 진행하는 곳이며, 플레이어와 딜러가 가진 정보를 OutputView에 전달하는 로직을 담당한다.

#### 
## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)
