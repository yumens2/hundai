# java-baseball-precourse
### 기능 요구 사항
* 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임
* 아래 3개 힌트를 이용해 상대방(컴퓨터)의 수를 맞추면 승리
  * 같은 수가 같은 자리에 있으면 스트라이크
  * 같은 수가 다른 자리에 있으면 볼
  * 같은 수가 전혀 없으면 낫싱
* 컴퓨터는 1부터 9까지 서로 다른 임의의 수 3개를 선택
* 게임 플레이어는 컴퓨터가 생각하고 있는 숫자 3개를 유추하여 입력
* 컴퓨터는 입력된 숫자에 대한 결과를 출력
* 게임이 종료된 후 게임을 다시 시작하거나 완전히 종료할 수 있음
* 잘못된 값이 입력된 경우 `IllegalArgumentException`을 발생시킨 후 종료되어야 함

### 기능 설계
* Application
  * [public] main: 프로그램 시작점
* BaseballGame
  * [public] start: 사용자가 종료를 원할 때까지 게임 반복 실행
  * [private] play: 숫자 야구 게임 진행
  * [private] getStrike: Strike 계산
  * [private] getBall: Ball 계산
* Computer
  * [public] setNumber: 랜덤값 변경
  * [public] getNumber: 랜덤값 가져오기
  * [private] generateRandomNumber: 랜덤값 생성
* Player
  * [public] getNumber: 입력값 가져오기
  * [public] void inputNumber: 3자리 수 입력 및 검증
  * [public] inputMenu: 게임 재시작 여부 입력 및 검증
  * [public] printScore(int strike, int ball): 결과 값 출력
