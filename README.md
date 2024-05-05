# java-baseball-precourse
## 구현할 기능
### Model
- **GameModel**
    - `int answer` 랜덤 정답
    - `boolean isCorrect` 정답 여부
    - `initAnswer()` 정답(랜덤 세 자리 숫자) 설정
    - `createResult()` 결과 생성 후 반환
    - `countBall()` Ball 개수 카운팅
    - `countStrike()` Strike 개수 카운팅
### View
- **GameView**
    - `getInput()` 사용자로부터 숫자 예상 입력
    - `getIsReplay()` 사용자로부터 재시작 여부 입력
    - `displayResult()` 사용자가 입력한 값에 대한 결과 출력
    - `displayException()` 잘못된 입력으로 발생된 예외 메시지 출력
    - `displayEnd()` 게임종료 메시지 출력
### Controller
- **GameController**
    - `boolean isReplay` 재시작 여부
    - `validateInput()` 사용자가 입력한 숫자 추측값 유효성 검사
    - `validateIsReplay` 사용자가 입력한 재시작 여부 값 유효성 검사
    - `play()` 게임 전체 흐름 제어
    - `playGuess()` 사용자 추측 단계 제어 및 예외 핸들링