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


### 구현할 기능 목록

- `utils/GenerateRandomNumber` - 플레이어가 알아내야하는 컴퓨터의 랜덤 숫자를 생성한다. 플레이어의 숫자와 비교할 때 편의성을 위해 List로 구현. 생성 시 중복불가, 0포함 불가, 3자리수 의 규칙을따른다.
- `utils/StringToArrayList` - 플레이어의 입력값인 문자열을 List로 바꿔주는 로직.
- `domain/Computer` - Computer 도메인. utils/GenerateRandomNumber를 통해 랜덤으로 숫자를 셋팅한다. getComputerNumbers() 메서드로 리스트를 반환받는다.
- `domain/Player` - Player 도메인. getter, setter메서드 구현.
- `exception/InputException` - 사용자가 힌트를 얻을 숫자 입력시 오류 검증. 세자리 수, 0 미포함, 중복 미포함 시 외에는 오류를 발생시킨다.
- `exception/RetryException` - 게임 재시작/종료 입력시 오류 검증. “1”,”2” 외에는 오류를 발생시킨다.
- `view/InputView` - 사용자 입력 시 보여지는 View.  입력받은 숫자에 대해 exception/ 을 사용해 오류 검사. 사용자가 입력한 숫자를 반환(게임 도중, 게임 끝난 뒤 두가지 모두)
- `view/OutputView` - 사용자 입력에 대한 View.
- `service/ScoreService` - 힌트를 얻기 위한 사용자 입력에 대한 힌트 값 계산 로직.  배열에 STRIKE, BALL 값 담아 반환.
- `service/GameService` - 정답을 맞춘 후 사용자 입력에 대한 게임 상태 반환 로직. 게임이 끝났다면 isEnd=true 반환.
- `controller/GameController`
  1. 전체적인 게임의 흐름 작성. 게임 시작
  2. 컴퓨터 랜덤 값 생성
  3. 사용자 값에 따른 힌트 출력(정답시 까지 반복),
  4. 정답 시 사용자 입력
  5. 사용자 입력(”1”일때 - 2번으로 이동, “2”일때 6번으로 이동)
  6. 게임 종료




