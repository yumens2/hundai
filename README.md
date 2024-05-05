# java-baseball-precourse
## 구현할 기능 목록
### 도메인
- [x] Ball : 하나의 숫자와 BallType을 가짐
- [x] BallType : 스트라이크인지, 볼인지 판단하는 enum 객체
- [x] Pitching: Ball 객체 3개를 List로 저장하는 VO, 몇개가 스트라이크이고 볼인지 알 수 있음

### BaseBallGame
- [x] 정답이 될 객체 생성
- [x] 피칭을 진행하고, 해당 피칭의 결과가 3스트라이크라면 게임 종료

### GameController
- [x] 어떤 게임을 실행할 지 알고있음
- [x] 게임의 재시작 여부 묻기

### DefaultGameService
- [x] 1부터 9까지 서로 다른 수로 이루어진 3자리 수 생성
- [x] 사용자의 입력과, 정답을 비교해서 피칭 생성. 이떄 비교후의 결과를 BallType으로 저장
