# java-baseball

1. Computer 클래스
   - 1부터 9까지의 겹치지 않는 숫자를 임의로 3개 선택하는 함수 (computerRandomNumbers())

2. User 클래스
   - 사용자로부터 3개의 숫자를 String으로 입력받는 함수 (getUserInputNumbers())

3. BaseballGame 클래스
   - 게임을 실행하는 함수(startGame())
   - 턴을 시작하고 사용자에게 숫자를 입력받는 함수(playTurn())
   - 사용자에게 입력받은 숫자가 문제 없으면 턴을 이어가는 함수(playContinue(List<Integer> userInputInt))
   - 스트라이크와 볼을 계산하는 함수(computeNum(List<Integer> userInputInt)
   - 스트라이크, 볼 수와 낫싱을 출력하는 함수(baseballResultPrint(BaseballCounter baseballCounter))
   - 스트라이크가 3이면 게임을 종료하는 함수(checkGameOver(BaseballCounter baseballCounter))
   - 게임 종료 후 새 게임을 시작할지 게임을 끝낼지 물어보는 함수(askForNewGame())

4. NumValidator 클래스
   - 입력받은 숫자가 3개인지 검사하는 함수(isCorrectLength(String input))
   - 3개인지 검사하는 함수를 통과한 숫자가 각각 1~9인지 검사하는 함수(isOneToNine(String input))
   - 두 검증을 마친 숫자가 중복이 있는지 검사하는 함수(isNotDuplicateNum(String input))
   - 최종적으로 턴 진행 시 사용자에게 입력받은 숫자가 올바른지 검증하는 함수(isNotDuplicateNum(String input))
   - (추가) 게임 종료 후 새 게임을 시작할지 숫자를 입력받아 1, 2인지 검사하는 함수(isOneOrTwo(String input))

5. BasballCounter 레코드 클래스
   - 스트라이크와 볼 수를 저장하는 클래스(레코드 클래스. 처음에 기본적인 VO로 만들었으나 동기가 레코드 클래스라는 것을 알려주어 실습 겸 사용해봄)

6. Application 클래스
   - main 메서드를 가진 클래스(여기서 게임이 시작됨)