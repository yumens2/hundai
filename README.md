# java-baseball-precourse

## 기능 목록

### 1. model 패키지
#### User 클래스
* int[] getNumbers()
  * 게임 플레이어가 입력한 문자열 숫자를 쪼개 `int[]`에 저장하여 반환하는 메서드

#### Computer 클래스
* Computer()
  * 컴퓨터의 서로 다른 임의의 3개의 숫자를 생성하여 `int[] number`에 저장하는 생성자 메서드

* int[] getNumbers()
  * 생성자를 통해 생성된 랜덤 숫자 반환



### 2. view 패키지

#### GameView 클래스

* String getUserInput()
  * 사용자의 입력을 받는 메서드

* void displayResult(int[] result)
  * 스트라이크와 볼에 대한 결과를 출력하는 메서드

* void displayGameEnd()
  * 게임 종료 메시지를 출력하는 메서드



### 3. controller 패키지

#### GameController 클래스
게임의 진행을 제어하는 클래스
* void startGame()
  * 게임을 시작하고 주 게임 루프를 실행

* void processUserNumber
  * 사용자의 숫자에 대한 처리를 하고 결과를 반환(실직적인 게임 진행)



### 4. service 패키지

#### GameService 클래스
게임의 로직을 실행하는 클래스
  * void countBall()
    * 동일한 숫자가 몇 개 있는지 확인하는 메서드

  * void countStrike()
    * 동일한 위치에 동일한 숫자가 있는지 확인하는 메서드

  * int[] getFeedback()
    * 볼/스트라이크 판별된 결과를 반환하는 메서드




### 5. util 패키지
#### NumberUtil 클래스
숫자에 관한 도움을 주는 static 메서드를 모은 클래스
* static int[] generateRandomNumber()
  * 컴퓨터가 랜덤한 3개의 숫자를 생성하는 메서드
* static int[] parseStringToNumbers(String)
  - 입력된 문자열이 유효한 지 검증하고 각각의 정수로 분리해 저장하는 메서드
* static boolean isDistinctNumbers(int[])
  - 크기가 3인 `int[]`가 주어지고, 주어진 값이 모두 서로 다른 수인지 검증하는 메서드



## 과제 요구 사항

### 과제 진행 요구 사항

* 미션은 숫자 야구 저장소를 포크하고 클론하는 것으로 시작한다.
* **기능을 구현하기 전 `README.md`에 구현할 기능 목록을 정리**해 추가한다.
* Git의 커밋 단위는 앞 단계에서 `README.md`에 정리한 기능 목록 단위로 추가한다.
  * [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)을 참고해 커밋 메시지를 작성한다.

#### Formating of commit message

```git
<type>(<scope>): <subject>
<BLANK LINE>
<body>
<BLANK LINE>
<footer>
```

커밋 메시지는 100자를 넘을 수 없음.

##### Allowed type

- feat (feature)
- fix (bug fix)
- docs (documentation)
- style (formatting, missing semi colons, …)
- refactor
- test (when adding missing tests)
- chore (maintain)





### 기능 요구사항

기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

* 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.

```text
e.g.
상대방(컴퓨터)의 수가 425일 때,
- 123을 제시한 경우: 1스트라이크
- 456을 제시한 경우: 1볼 1스트라이크
- 789를 제시한 경우: 낫싱
```

* 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는
  3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
* 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
* 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
* 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.



### 실행 결과

```text
숫자를 입력해 주세요 : 123
1볼 1스트라이크
숫자를 입력해 주세요 : 145
1볼
숫자를 입력해 주세요 : 671
2볼
숫자를 입력해 주세요 : 216
1스트라이크
숫자를 입력해 주세요 : 713
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
1
숫자를 입력해 주세요 : 123
1볼
…
```



### 프로그래밍 요구사항 1

* JDK 17 버전에서 실행 가능해야 한다.
* 프로그램 실행의 시작점은 `Application`의 `main()`이다.
* `build.gradle`파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
* 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
* 프로그래밍 요구사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.



### 프로그래밍 요구사항 2

* 자바 코드 컨벤션을 지키면서 프로그래밍 한다.
  * 기본적으로 [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)을 원칙으로 한다.
  * 단, 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다.
* indent depth를 3이 넘지 않도록 구현한다. 2까지만 허용
  * 예를 들어, while문 안에 if문이 있으면 들여쓰기는 2이다.
  * 힌트: indent depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
* 3항 연산자를 쓰지 않는다
* 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라
* JUnit5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
* 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
  * [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
  * [AssertJ User Guide](https://assertj.github.io/doc/)
  * [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion)
  * [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)



