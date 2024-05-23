# java-baseball-precourse


## 기능 구현 과정 (commit 순서별 정렬)

* createRandomNumbers 메소드에 1~9까지의 랜덤 숫자 생성 기능 구현
* 숫자 중 몇개가 같은지 return하는 기능을 가진 matchNumber 메소드 추가
* PlaceNumber에 number가 있는지 여부를 return하는 기능 추가
* computer와 player의 숫자를 compare하여 출력하는 기능을 가진 메소드 추가
* main문에 우선 반복 없이 게임 수행하는 기능 구현
* playerNumber를 입력받고 리스트로 만들어 리턴하는 기능 구현
* scan기능을 따로 분리하기 위해 NumberScanner Class 생성 후 구현
* main문 깊이 조절을 위한 Print 클래스 생성 후 구현
* Print 클래스 내에 실제 print부분을 묶은 gamePrint메소드 생성
* main문을 반복 조건에 수정
    * 1을 입력하면 반복
    * 2를 입력하면 종료
    * 이외의 숫자를 입력하면 오류 발생

## Test코드

* createRandomNumbers가 생성한 숫자의 길이가 3인지 테스트하는 기능 구현
* createRandomNumbers가 생성한 숫자의 범위가 1~9인지 테스트하는 기능 구현
* createRandomNumbers가 생성한 숫자들이 서로 다른지 테스트하는 기능 구현
* 컴퓨터와 플레이어 리스트 숫자가 모두 다를 경우 result가 0인지 테스트하는 기능 구현
* 컴퓨터와 플레이어의 리스트에 2개의 숫자가 같은 경우 result가 2인지 테스트하는 기능 구현
* placeCheck메소드가 정상 작동하는지 테스트하는 기능 구현
* Application에서 3스트라이크 후 1,2가 아닌값을 입력했을 때, 정상적으로 오류를 출력하는지 테스트하는 기능 구현

### -> Test결과 모두 정상