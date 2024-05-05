# java-baseball

## 설명
이 프로그램은 숫자 야구 게임을 구현한 Java 애플리케이션입니다. 사용자는 컴퓨터가 생성한 숫자를 맞히는 게임을 실행합니다.


## 기능 설명
1. **generateComputerNumbers(): 컴퓨터가 임의의 서로 다른 세 자리 숫자를 생성하는 메서드입니다.
2. **getPlayerInput(): 사용자로부터 세 자리 숫자를 입력받는 메서드입니다.
3. **convertInputToArray(): 입력받은 숫자를 문자열에서 정수 배열로 변환하는 메서드입니다.
4. **checkInputValidity(): 입력된 숫자가 세 자리이고 중복이 없는지 확인하는 메서드입니다.
5. **checkForDuplicates(): 입력된 숫자 배열에서 중복된 숫자가 있는지 확인하는 메서드입니다.
6. **strikeCheck(): 사용자가 입력한 숫자와 컴퓨터가 생성한 숫자 사이에서 스트라이크를 계산하는 메서드입니다.
7. **ballCheck(): 사용자가 입력한 숫자와 컴퓨터가 생성한 숫자 사이에서 볼을 계산하는 메서드입니다.
8. **countBallsWithoutDuplicates(): 중복을 제외한 볼의 개수를 계산하는 메서드입니다.
9. **resultPrint(): 게임 결과를 출력하는 메서드입니다.


## 코드 구조

```plaintext
baseball
│
├── main
│   ├── generateComputerNumbers()
│   ├── getPlayerInput()
│   ├── convertInputToArray()
│   ├── checkInputValidity()
│   ├── checkForDuplicates()
│   ├── strikeCheck()
│   ├── ballCheck()
│   ├── countBallsWithoutDuplicates()
│   └── resultPrint()
│
└── main
    └── playGame()