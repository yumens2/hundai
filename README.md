# java-baseball-precourse
## 구현 목표
- 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의
수를 맞추면 승리한다.
- 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는
  3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 을 발생시킨 후 애플리케이션은 종료되어야 한다.
- 숫자 야구 게임을 진행하기 위한 여러 변수들을 초기화하고 while 반복문으로 게임이 진행되도록 한다.
## 구현 기능
1. 시작 메서드 main() 
Game 클래스에서 static void main() 시작 메서드를 통해 게임을 시작합니다. while 문과 아래의 메서드들을 활용하여 게임을 진행합니다. 
2. 숫자 생성 메서드
CreateNum 메서드에 정의된 createNumbers() 메서드는 컴퓨터의 세 자리 숫자를 난수로 생성하여 String 형태로 반환합니다.
3. 볼과 스트라이크 개수 세기
CountNum 클래스에 정의된 countSB(String userNum, String compNum) 메서드는 입력받은 userNum과 compNum을 비교하여 볼과 스트라이크의 개수를 문자열로 반환합니다. 예를 들어 볼이 1개, 스트라이크가 1개이면 "11"을 반환합니다.
4. 스트라이크 개수 세기
countS(String userNum, String compNum) 메서드는 스트라이크의 개수를 세는 메서드입니다. countSB 메서드 내부에서 호출됩니다.
5. 볼 개수 세기
countB(String userNum, String compNum) 메서드는 볼의 개수를 세는 메서드입니다. countSB 메서드 내부에서 호출됩니다.
6. 결과 출력
PrintInfo 클래스에 정의된 printResult(String count) 메서드는 countNum 메서드로 반환된 문자열 값을 받아서 결과를 출력합니다. 반환 값은 정답 여부를 나타내는 boolean 변수에 저장됩니다.
7. 정답 확인 및 게임 진행 여부 결정
userChoice() 메서드는 게임이 종료된 후 1 혹은 2를 입력하여 게임을 다시 실행할 지 종료할 지를 결정합니다.
8. 입력 예외 처리
이 때 userChoice() 메서드에서 호출되는 InputUserChoice() 메서드나 사용자의 입력을 처리하는 InputUserNum() 메서드는 잘못된 입력을 확인한 뒤 IllgealArgumentException을 throw하는 기능을 처리합니다.   