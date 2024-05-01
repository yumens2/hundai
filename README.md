# java-baseball-precourse

## 기능 구현 예정 목록
- [ ] Application 클래스
  - [ ] 게임 시작 전 Random값을 주입하는 기능
  - [ ] 새로운 게임을 시작하는 기능


- [ ] Computer 클래스
  - [ ] 랜덤값 생성 기능
  - [ ] 값 비교 기능


- [ ] Controller 클래스
  - [ ] Computer 세팅 기능
  - [ ] 게임 시작 기능
  - [ ] Input 기능
    - [ ] 각 Input을 형에 맞추어 반환
  - [ ] Output 기능


- [ ] Service 클래스
  - [ ] Strike, Ball을 합쳐 GameResult DTO로 반환 기능


- [ ] Util 클래스
  - [ ] 랜덤값 생성 기능
  - [ ] Input값이 형식에 맞는지 확인
    - [ ] Human Input이 숫자형인지 확인
    - [ ] Human Input에 중복된 값이 있는지 확인 -> 도메인로직으로 이동 가능성 O
    - [ ] Restart Game이 숫자형인지 확인
  
## Test 목록
### Computer Class Test
- [ ] Strike 개수 반환 Test
- [ ] Ball 개수 반환 Test
#### Computer Number Test
- [ ] Capacity가 0이하, 10이상의 유효하지 않은 값이 들어왔을 때 오류 던짐 Test

## GameService
- [ ] GameResult 반환 테스트

## View
- [ ] 입력 테스트
  - [ ] humanValue 입력시 List형식의 숫자 반환 테스트
  - [ ] GameType 입력시 int형 숫자 반환 테스트
- [ ] 출력 테스트

## Util
- [ ] 유효하지 않은 값 입력 시 오류 던짐 테스트
- [ ] 랜덤값 생성 테스