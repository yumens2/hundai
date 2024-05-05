# java-baseball-precourse
## 구현 기능 목록
- 게임 시작 기능
    -  startGame 메서드로 숫자야구 게임을 시작함
- 무작위 3자리 수 생성 (1부터 9까지 서로 다른 임의의 수 3개)
    - generateRand 메서드로 무작위 3자리 수를 생성함
- 사용자의 입력을 받는 기능
    - getInput 메서드로 사용자의 입력을 받음
    - isUniqueDigits 메서드로 각 자리수가 유일한지 판단함
    - isValidDigits 메서드로 유효한 정수인지 판단함
    - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 발생
- 사용자의 입력과 난수를 비교하는 기능
    - computeBallCount() 메서드로 사용자의 입력과 난수를 비교함
    - 3개의 숫자를 모두 맞히면 게임이 종료됨
    - 아닐 경우 입력한 숫자에 대한 결과를 출력함
- 재시작 혹은 종료 기능
    - 사용자의 입력에 따라 startGame() 메서드를 호출하거나 애플리케이션을 종료함
    - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 발생