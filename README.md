# java-baseball-precourse

## 기능 구현 예정 목록
- [x] Application 클래스
  - [x] 게임 시작 전 Random값을 주입하는 기능
  - [x] 새로운 게임을 시작하는 기능


- [x] Computer 클래스
  - [x] 랜덤값 생성값 주입 기능
  - [x] 값 비교 기능


- [x] Controller 클래스
  - [x] Computer 세팅 기능
  - [x] 게임 시작 기능
  - [x] Input 기능
    - [x] 각 Input을 형에 맞추어 반환
  - [x] Output 기능


- [x] Service 클래스
  - [x] Strike, Ball을 합쳐 GameResultDTO로 반환 기능


- [x] Util 클래스
  - [x] 랜덤값 생성 기능
  - [x] Input값이 형식에 맞는지 확인
    - [x] Human Input이 숫자형인지 확인
    - [x] Human Input에 중복된 값이 있는지 확인 -> 도메인로직으로 이동 가능성 O
    - [x] Restart Game이 숫자형인지 확인
  
## Test 목록
### Computer Class Test
- [x] Strike 개수 반환 Test
- [x] Ball 개수 반환 Test
#### Computer Number Test
- [x] Computer생성 시 다른 사이즈의 Random Array 주입 시 오류 던짐
- [x] countStrike, countBall 매서드 호출 시 HumanValue 가 ComputerValue와 자리수 불일치 시 오류 던짐

## GameService
- [ ] GameResult 반환 테스트

## View
- [ ] 입력 테스트
  - [ ] humanValue 입력시 List형식의 숫자 반환 테스트
  - [ ] GameType 입력시 int형 숫자 반환 테스트
- [ ] 출력 테스트

## Util
- [ ] 유효하지 않은 값 입력 시 오류 던짐 테스트
- [ ] 랜덤값 생성 테스트