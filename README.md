# java-baseball-precourse

1. Game 추상 클래스를 생성한다. Game클래스는 play, askNewGame 와 printEndGame메서드 가짐
2. Game클래스를 상속받는 BaseballNumberGame 클래스를 생성
3. BaseballNumberGame클래스는 내부 변수로 answer변수 가짐
4. 겹치지 않는 숫자를 랜덤으로 생성하는 createRandomNumber 메서드 생성
5. 사용자로 부터 숫자를 입력받는 selectNumber메서드 생성
6. answer와 입력받은 숫자를 토대로 strike와 ball을 체크하는 checkStrike, checkBall 메서드 생성
7. strike, ball에 대한 정보를 출력하는 printFeedback 메서드 생성
8. 게임종료 메시지를 출력할 printEndGame메서드 재정의
9. 다시 시작할지 물어보는 askNewGame메서드 재정의
10. Application의 main에서 BaseballNumberGame객체 생성 후 play
