# java-baseball-precourse

## 요구 사항

* jdk version 17에서 실행 가능한 숫자야구 게임을 만들어야한다.
* 1 ~ 9 사이의 서로 다른 수로 이루어진 3자리 수를 맞춰야하며, 틀리면 숫자야구 규칙에 따라 힌트를 준다.

```
e.g. 생성된 수가 425 :
- 123을 제시한 경우 : 1 스트라이크
- 456을 제시한 경우 : 1볼 1스트라이크
- 789를 제시한 경우 : 낫싱
```

* 3개의 숫자를 모두 맞히면 게임이 종료된다.
* 게임이 종료된 후, 게임을 다시 시작하거나 완전히 종료할 수 있다.
* 사용자가 잘못된 값을 입력할 경우 illegalArgumentException 을 발생, Application은 종료되어야 한다.
* 시작 클래스는 Application이다.
* build.gradle 파일은 변경하면 안되며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
* 프로그램 종료 시 System.exit()를 호출하지 않는다.
* 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
* 자바 코드 컨벤션을 지키면서 프로그래밍한다. ( 기본적으로 [Google java Style Guide](https://google.github.io/styleguide/javaguide.html)을 원칙으로 하며, 들여쓰기는 '4 spaces'이다.)
* indent depth는 2까지만 허용된다. (e.g. 2중 중첩 for문)
* 3항 연산자는 사용하지 않는다.
* 함수/메서드가 한 가지 일만 하도록 최대한 작게 만든다.
* JUnit 5, AssertJ를 이용해 정리한 기능 목록이 정상적으로 작동하는 지 테스트 코드로 확인한다.
  [참고] [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide), [AssertJ User Guide](https://assertj.github.io/doc), [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion), [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)

### 실행결과

```
숫자를 입력해 주세요 : 123 1볼 1스트라이크
숫자를 입력해 주세요 : 145 1볼
숫자를 입력해 주세요 : 671 2볼
숫자를 입력해 주세요 : 216 1스트라이크
숫자를 입력해 주세요 : 713
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. 1
숫자를 입력해 주세요 : 123
1볼
...
```

### 구현할 기능 목록

---

Application : 게임시작

Game

* 랜덤으로 숫자 세 개를 받아옴
* 사용자에게 숫자 세 개를 받아와서, 숫자가 일치하는 지 확인 후 해당하는 결과를 출력
* 잘못된 값을 입력하는 지 확인
* 숫자를 모두 맞추면, 게임 종료후, 게임을 다시 시작할 것인지에 대한 안내 출력

RandomThreeNumGenerator

* 랜덤으로 중복되지 않는 숫자 세 개를 생성

UserInput

* 사용자로부터 문자열을 입력받음

ResultCalculator

* 사용자가 입력한 숫자에 대한 결과값을 계산

ExceptOccurCheck

* 사용자가 잘못된 값을 입력했는 지 확인
