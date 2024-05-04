# [전남대 BE_이현기] 카카오 테크 캠퍼스 1차 미니 과제(java-baseball)

## 기능 목록

| 번호 | 기능 코드 | 기능명 Depth1    | 기능명 Depth2             | 기능명 Depth3                                | 기능정의                                                                                                                                    |
|----|-------|---------------|------------------------|-------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------|
| 1  | bb-01 | Baseball Game |                        |                                           | - 컴퓨터는 임의의 숫자를 생성하고, 사용자는 임의의 숫자를 맞춘다.                                                                                                  |
| 2  | bb-02 | Baseball Game | Generate Random Number |                                           | - 컴퓨터는 임의의 n개의 숫자를 선택한다.<br> - 초기 수열의 길이는 3이다.                                                                                              |
| 3  | bb-03 | Baseball Game | Generate Random Number | Validation First Number                   | - 임의로 생성한 숫자의 첫번째 자리는 반드시 0이 아니다.                                                                                                       |
| 4  | bb-04 | Baseball Game | Generate Random Number | Validation Each Number                    | - 임의로 생성한 숫자는 반드시 서로 다른 수여야 한다.                                                                                                         |
| 5  | bb-05 | Baseball Game | Generate Random Number | Validation Number Length                  | - 임의로 생성한 숫자의 길이는 반드시 [1,9]의 범위를 가져야 한다.                                                                                                |
| 6  | bb-06 | Baseball Game | User Input             |                                           | - 사용자가 입력을 한다.                                                                                                                          |
| 7  | bb-07 | Baseball Game | User Input             | Predict Input                             | - 사용자는 n자리의 서로 다른 숫자를 입력한다                                                                                                              |
| 8  | bb-08 | Baseball Game | User Input             | Validation Predict Input Not Number       | - 사용자가 예측할 때 숫자가 아닌 값을 입력하면 IllegarArguemntException을 발생시킨다.                                                                            |
| 9  | bb-09 | Baseball Game | User Input             | Validation Predict Input Same Number      | - 사용자가 예측할 때 같은 숫자를 두번 이상 사용하면 IllegarArgumentException을 발생시킨다.                                                                         |
| 10 | bb-10 | Baseball Game | User Input             | Validation Predict Input Not Equal Length | - 사용자가 예측할 때 숫자의 길이가 n과 같지 않으면 IllegarArgumentException을 발생시킨다.                                                                         |
| 11 | bb-11 | Baseball Game | User Input             | Restart Input                             | - 사용자는 게임을 재시작할려면 1을, 종료하려면 2를 입력한다.                                                                                                    |
| 12 | bb-12 | Baseball Game | User Input             | Validation Restart Input                  | - 사용자가 게임을 재시작할 때 1과 2를 제외한 값을 입력하면 IllegarArgumentException을 발생시킨다.                                                                    |
| 13 | bb-13 | Baseball Game | Compare Number         |                                           | - 사용자가 예측한 숫자와 컴퓨터가 생성한 숫자를 비교한다.                                                                                                       |
| 14 | bb-14 | Baseball Game | Compare Number         | Strike                                    | - 사용자가 입력한 숫자와 컴퓨터가 생성한 숫자를 비교해, 자리와 위치가 일치하는 개수를 리턴한다.                                                                                 |
| 15 | bb-15 | Baseball Game | Compare Number         | Ball                                      | - 사용자가 입력한 숫자와 컴퓨터가 생성한 숫자를 비교해, 다른 자리에 있는 같은 숫자의 개수를 리턴한다.                                                                             |
| 16 | bb-16 | Baseball Game | Compare Number         | Nothing                                   | - 사용자가 입력한 숫자와 컴퓨터가 생성한 숫자를 비교해, 일치하는 숫자가 없으면 "낫싱"을 리턴한다.                                                                               |
| 17 | bb-17 | Baseball Game | Play Game              |                                           | - 야구 게임을 시작한다.                                                                                                                          |
| 18 | bb-18 | Baseball Game | Play Game              | Start                                     | - 컴퓨터는 임의의 숫자를 생성한다.                                                                                                                    |
| 19 | bb-19 | Baseball Game | Play Game              | Get Input                                 | - 사용자에게 "숫자를 입력해 주세요 : "를 출력하고 Predict(bb-07)를 호출해 입력을 받는다.                                                                             |          
| 20 | bb-20 | Baseball Game | Play Game              | Result                                    | - 컴퓨터가 생성한 숫자와 사용자에게 입력받은 값을 Compare(bb-13)를 호출하여 값을 가져와 출력한다.                                                                          |
| 21 | bb-21 | Baseball Game | Play Game              | Check Result                              | - Result(bb-20)의 값이 n스트라이크이면, "n개의 숫자를 모두 맞히셨습니다! 게임 종료"를 출력하고, Flag를 False로 변경한다.                                                      |
| 22 | bb-22 | Baseball Game | Play Game              | Restart Game                              | - "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요"를 출력하고, Restart Input(bb-11)을 호출해 입력값을 받는다. <br> - 값이 1이면 Start(bb-18)를 호출한다. <br> - 값이 2이면 게임을 종료한다. |                                    

> ## 과제 진행 요구사항
>> - 미션은 숫자 야구 저장소를 포크하고 클론하는 것으로 시작한다. <br>
>> - 기능을 구현하기 전 README.md 에 구현할 기능 목록을 정리해 추가한다. <br>
>> - Git의 커밋 단위는 앞 단계에서 README.md 에 정리한 기능 목록 단위로 추가한다. <br>
>> - [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)을 참고해 커밋 메시지를
     작성한다.<br>
>> - 자세한 과제 진행 방법은 미니과제 진행 가이드 문서를 참고한다. <br>
> ## 기능 요구사항
>> - 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다. <br>
>> - 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다. <br>
>>> e.g. <br>
> > > 상대방(컴퓨터)의 수가 425일 때,<br>
> > > 123을 제시한 경우: 1스트라이크 <br>
> > > 456을 제시한 경우: 1볼 1스트라이크<br>
> > > 789를 제시한 경우: 낫싱<br>
>>
>> - 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에
     대한 결과를 출력한다. <br>
>> - 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.<br>
>> - 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.<br>
>> - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다. <br>
> ## 실행 결과
>> 숫자를 입력해 주세요 : 123 <br>
> > 1볼 1스트라이크<br>
> > 숫자를 입력해 주세요 : 145<br>
> > 1볼<br>
> > 숫자를 입력해 주세요 : 671<br>
> > 2볼<br>
> > 숫자를 입력해 주세요 : 216<br>
> > 1스트라이크<br>
> > 숫자를 입력해 주세요 : 713<br>
> > 3스트라이크<br>
> > 3개의 숫자를 모두 맞히셨습니다! 게임 종료<br>
> > 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.<br>
> > 1<br>
> > 숫자를 입력해 주세요 : 123<br>
> > 1볼<br>
> > ...<br>
> ## 프로그래밍 요구사항
>> - JDK 17 버전에서 실행 가능해야 한다. <br>
>> - 프로그램 실행의 시작점은 Application 의 main() 이다.<br>
>> - build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.<br>
>> - 프로그램 종료 시 System.exit() 를 호출하지 않는다.<br>
>> - 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.<br>
>> - 자바 코드 컨벤션을 지키면서 프로그래밍한다.<br>
>>> 기본적으로 [Google Java Style](https://google.github.io/styleguide/javaguide.html) Guide을 원칙으로 한다.<br>
> > > 단, 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다.<br>
>>
>> - indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.<br>
>>> 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.<br>
> > > 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.<br>
>>
>> - 3항 연산자를 쓰지 않는다.<br>
>> - 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.<br>
>> - JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다<br>
>> - 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.<br>
>>> [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)<br>
> > > [AssertJ User Guide](https://assertj.github.io/doc/)<br>
> > > [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion)<br>
> > > [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)<br>