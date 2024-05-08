# java-baseball-precourse



## <구현기능>

1. 컴퓨터가 무작위로 숫자 생성하는 기능
- generateComputerNumbers() 메서드는 주어진 DIGIT_COUNT에 따라 랜덤한 숫자 배열을 생성.
- Random 클래스를 사용해 MIN_NUMBER와 MAX_NUMBER 사이의 랜덤한 숫자를 생성.
- 중복된 숫자가 생성되지 않도록 중복 체크
  
2. 사용자로부터 숫자를 입력받고 유효성을 검사하는 기능
- getUserNumbers(Scanner scanner) 
- 입력된 숫자의 길이가 DIGIT_COUNT와 일치하는지 확인하고 숫자가 아닌 문자가 입력되었는지 검사
- 입력된 숫자가 MIN_NUMBER와 MAX_NUMBER 사이의 범위 내에 있는지 확인

3. 입력된 숫자와 컴퓨터가 생성한 숫자를 비교해 결과를 출력하는 기능
- checkMatch(int[] computerNumbers, int[] userNumbers) 
- 스트라이크와 볼을 계산하여 결과를 출력
- 모든 숫자가 일치시 게임을 종료
  
4. 게임 재시작 또는 종료하는 기능
- 게임을 종료할지 재시작할지 사용자로부터 입력 받기
- 사용자가 1을 입력하면 게임을 재시작하고, 2 입력시 종료
