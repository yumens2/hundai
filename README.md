# java-baseball-precourse

## 부산대 BE 이영준

### info

풀 리퀘스트 제목 : [부산대 BE_이영준] 미션 제출합니다.

구글 폼 PR 링크 포함 최종 제출하기
과제 진행 소감과 함께?

version : Java 17

# 요구 사항

### 최종 목표

1~9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 프로그램

### 프로그래밍 요구 사항

- JDK 17
- entry point : Application main()
- read only : [build.gradle](build.gradle)

- 프로그램 종료 시 System.exit() 호출 X

- 자바 코드 컨벤션 준수
- depth 2
- 메서드 단일 책임 단일 역할
- test code 작성

---

# 대략적인 설계

1. BaseBallMaker class 만들기 - 야구게임을 진행함.
2. GameManager class 만들기 - 사용자 입력을 받아서 진행
3. main 내부에서 진행되도록 함.

# 기능 단위 구현 목표

## BaseBallMaker

- 처음 BaseBall에 랜덤한 수를 설정한다.
- 외부의 BaseBall과 설정된 BaseBall을 비교해서 결과를 전달한다.

## GameManager

- 게임의 규칙을 안다.

- 사용자의 시작 입력을 받는다.
- 사용자의 숫자 추측 입력을 받아 BaseBallMaker에 전달한다.
- 반환받은 결과를 사용자에게 전달한다.
- 만약, 게임이 종료되면, 게임을 종료한다.

## BaseBallVO

- int ball1
- int ball2
- int ball3

볼에 관한 정보를 담고 있다.
- equal()

## BaseBallAnsVO

- bool isEnd
- int strikeCount
- int ballCount

- toString()

## commit - plan

1. init
2. BaseBallVO Class 구현

3. BaseBallMaker 생성자 구현
4. BaseBallMaker:: void make()
   -> BaseBallVO를 생성해서 랜덤한 수 지정
5. test - make

6. BaseBallAnsVO Class 구현
7. BaseBallMaker:: BaseBallAnsVO playBall(const BaseBallVO vo)
   -> BaseBallVO에 따라서 결과를 반환
8. test - playBall

9. GameManager:: 생성자 구현
10. GameManager:: void userInput();
    -> 사용자 입력을 받음
11. GameManager:: void userOutput(BaseBallAnsVO);
    -> 사용자에게 출력


## log



