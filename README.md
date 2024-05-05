# java-baseball-precourse
***
## 구현할 기능 목록
***
* 사용자
  * [ ] 숫자를 입력한다.

* 컴퓨터
  * [ ] 1 ~ 9 까지의 서로 다른 임의의 수 3개(정답)를 생성한다.
  * [ ] 사용자의 입력값과 생성된 정답을 비교하여 판정(스트라이크, 볼, 낫싱)한다.

* 진행자
  * [ ] 필요한 안내 문구를 출력한다.
    * 게임 시작 문구
    * 스트라이크, 볼, 낫싱 판정 문구
    * 게임 종료 문구
  * [ ] 사용자가 정답을 맞추어야 게임이 종료된다.
  * [ ] 정답을 맞추면 다시 플레이할지 종료할지 사용자에게 물어본다.

### 예외 상황
***
* 입력
  * [ ] 입력한 숫자의 길이가 3자리가 아닌 경우
  * [ ] 입력 내용에 숫자가 아닌 문자가 있는 경우
  * [ ] 재시도 입력 시 1 또는 2가 아닌 경우

## 구현한 기능 소개
***
```
 baseball
    ├── BaseballApplication.java
    ├── domain
    │   ├── BallCount.java
    │   ├── BaseballNumber.java
    │   ├── Computer.java
    │   └── constants
    │       └── CountType.java
    ├── exception
    │   └── constants
    │       └── ErrorMessage.java
    ├── system
    │   ├── GameManager.java
    │   └── constants
    │       ├── Command.java
    │       └── Rule.java
    ├── utils
    │   └── RandomNumberGenerator.java
    ├── validator
    │   └── RandomNumberValidator.java
    └── view
        ├── InputView.java
        ├── OutputView.java
        └── constants
            └── GameMessage.java
```
### domain 패키지
숫자야구에 필요한 도메인을 구성합니다.

* ```BallCount```
  * 사용자의 입력에 대한 볼카운트를 의미합니다.
* ```BaseballNumber```
  * 숫자야구에서 사용될 숫자 집합을 의미합니다. 
  * ex) 123, 182
* ```Computer```
  * 게임의 상대방을 의미합니다.
  * ```RandomNumberGenerator```에서 발생한 난수를 바탕으로 자신의 ```BaseballNumber``` 를 생성하고 사용자의 입력과 자신의 숫자를 비교하는 책임을 지닙니다.
* ```CountType```
  * 숫자야구에서 결과로 나타나는 스트라이크, 볼, 낫싱에 대해 상수로 관리합니다.
  
### exception 패키지
사용자 정의 예외와 예외와 관련된 상수를 구성합니다.
현재는 추가로 정의한 사용자 정의 예외는 없습니다.

* ```ErrorMessage```
  * 예외 발생 시, 출력할 문구에 대하여 상수로 관리합니다.

### system 패키지
게임 운영과 관련된 클래스들을 구성합니다.

* ```GameManager```
  * 숫자야구에 필요한 모듈들을 모아 게임을 진행시킵니다.
* ```Command```
  * 숫자야구에서 사용되는 명령어를 상수로 정의합니다.
* ```Rule```
  * 숫자야구에서 지켜야 할 규칙에 대해 상수로 정의합니다.
  * ex) 숫자야구에서 사용할 숫자집합의 길이, 숫자의 범위

### utils 패키지
프로젝트 전역에서 사용할 편의성을 위한 패키지입니다.
* ```RandomNumberGenerator```
  * 난수 생성기를 의미하며 서로 독립적인 숫자를 갖는 난수를 발생시킵니다.

### validator 패키지
검증과 관련된 클래스를 구성합니다.

* ```RandomNumberValidator```
  * 난수 발생과 관련하여 난수의 길이에 대하여 검증합니다.

### view 패키지

* ```InputView```
  * 입력과 관련된 안내문구를 출력합니다.
* ```OutputView```
  * 출력과 관련된 안내문구를 출력합니다.
* ```GameMessage```
  * 뷰에서 사용할 안내문구를 상수로 관리합니다.