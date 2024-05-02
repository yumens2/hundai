# java-baseball-precourse

### 숫자야구 프로그램
- 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 준다.
- 상대방 역할은 컴퓨터가 하며 1에서 9까지의 서로 다른 임의의 수 3개를 선택한다.
- 플레이어는 예상하는 숫자 3개를 입력하고 컴퓨터는 입력한 숫자에 대한 힌트를 출력한다.
- 게임을 종료 한 후 게임을 다시 시작하거나 숫자를 모두 맞히면 게임이 종료된다.
- 게임을 종료한 후 1을 입력하면 게임을 다시 시작하고, 2를 입력하면 게임을 완전히 종료한다.
- 잘못된 값을 입력한 경우 `IllegalArgumentException`을 발생시킨후 애플리케이션은 종료된다.


### 프로젝트 구조
```bash
├──controller
│   └── GameController
│   
│──domain
│   ├── Player
│   └── Computer
│ 
├── exception
│   ├── InputException
│   └── RetryException
│
├── service
│   ├── GameService
│   └── ScoreService
│
├── utils
│   ├── GenerateRandomNumber
│   └── StringToArrayList
│
├── view
│   ├── InputView
│   └── OutputView
│
└── Application
``` 
- 최대한 MVC 패턴에 의거하여 코드를 작성하였다.
- 프로그래밍 요구사항에 의거해 indent depth를 줄이기 위해 최대한 역할을 분리했다.

- Controller
  - View를 통해 화면을 출력하고 Service를 통해 로직을 수행한다.
- Domain
  - Player, Computer 객체의 정보를 설정하거나 반환한다.
- Exception
  - 입력시 발생할 수 있는 오류를 처리한다.
- Service
  - 힌트를 반환하는 로직이나 게임이 끝난 뒤 게임을 다시 시작할지, 종료할지 로직을 처리한다.
- utils
  - 랜덤 숫자를 생성하거나, 힌트 비교를 위해 입력받은 String을 ArrayList로 바꿔주는 유틸.
- View
  - 메시지를 콘솔에 출력해주는 역할.






