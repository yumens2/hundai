# 구현할 기능 목록들 
## 1. 게임 시작 시 1~9까지 서로 다른 수로 이루어진 3자리의 수를 생성한다.
- [x] 프로그램의 시작점은 Application main()이다. 
- [x] 게임 시작 메서드 구현 (StarGame 클래스의 startGame 메서드)
- [x] 3자리의 수의 난수를 생성하는 메서드 구현 (RandomNumber 클래스의 generateRandomNumbers 메서드)

## 2. 게임 플레이어인 사용자로부터 3자리의 수를 입력받는다. 
- [x] 사용자로부터 3자리의 수를 입력받는 메서드 구현 (input 클래스의 inputNumber 메서드)
- [x] 사용자로부터 입력받은 수의 유효성 검사 메서드 구현 (Validate 클래스의 isValid 메서드)
- [x] 난수와 사용자가 입력한 수를 비교하여 결과 출력 (스트라이크, 볼, 낫싱) (BaseballGame 클래스의 play 메서드)

## 3. 게임 종료 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
- [x] 게임 재시작 혹은 종료 여부를 묻는 메서드 구현 (ContinueOrNot 클래스의 isContinueGame 메서드)

## 구현 후 테스트 
- [x] 유효성 검증 테스트 코드 작성 (ValidateTest 클래스의 isValidTest 메서드)
- [x] 난수 생성 테스트 코드 작성 (RandomNumberTest 클래스의 generateRandomNumbersTest 메서드)
- [x] 게임 플레이 테스트 코드 작성 (BaseballGameTest 클래스의 playTest 메서드)
- [x] 게임 재시작 혹은 종료 여부 테스트 코드 작성 (ContinueOrNotTest 클래스의 isContinueGameTest 메서드)
```


