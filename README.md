# Baseball Game

## 소개
이 프로그램은 숫자 야구 게임을 구현한 Java 애플리케이션입니다. 사용자는 컴퓨터가 생성한 숫자를 맞히는 게임을 플레이할 수 있습니다.

## 코드 구조

```plaintext
baseball
│
├── main()
│   ├── Scanner 객체 생성
│   ├── boolean 변수 playAgain 선언
│   ├── do-while 루프
│   │   ├── playGame() 호출
│   │   ├── "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." 출력
│   │   ├── 사용자 입력을 받아서 choice 변수에 저장
│   │   ├── playAgain에 choice 값에 따라 true 또는 false 할당
│   ├── 루프 종료 후 "프로그램 종료!" 출력
│   └── Scanner 객체 닫기
│
├── playGame(Scanner scanner)
│   ├── player 배열 선언
│   ├── computer 배열 생성 및 초기화
│   ├── int 변수 strikes, balls 선언
│   ├── do-while 루프
│   │   ├── getPlayerInput() 호출하여 player에 저장
│   │   ├── strikes에 strikeCheck() 결과 저장
│   │   ├── balls에 ballCheck() 결과 저장
│   │   ├── resultPrint() 호출하여 결과 출력
│   ├── 루프 종료 조건: strikes가 3이 될 때까지
│
├── getPlayerInput(Scanner scanner)
│   ├── player 배열 선언
│   ├── computer 배열 생성 및 초기화
│   ├── int 변수 strikes, balls 선언
│   ├── do-while 루프
│   │   ├── "숫자를 입력해 주세요 :" 출력
│   │   ├── 사용자 입력을 받아서 input에 저장
│   │   ├── input을 convertInputToArray()로 변환하여 player에 저장
│   │   ├── player의 유효성을 checkInputValidity()로 검사
│   │   ├── 유효하지 않으면 메시지 출력 후 프로그램 종료
│   ├── 루프 종료 조건: checkInputValidity가 true일 때까지
│   └── player 반환
│
├── convertInputToArray(String input)
│   └── 입력된 문자열을 분할하여 정수 배열로 변환하여 반환
│
├── checkInputValidity(int[] player)
│   └── player 배열이 유효한지 확인하고 결과 반환
│
├── checkForDuplicates(int[] player)
│   └── player 배열에 중복된 요소가 있는지 확인하고 결과 반환
│
├── generateComputerNumbers()
│   └── 컴퓨터의 숫자 배열을 생성하여 반환
│
├── strikeCheck(int[] player, int[] computer)
│   └── player와 computer 배열을 비교하여 스트라이크 개수 반환
│
├── ballCheck(int[] player, int[] computer)
│   └── player와 computer 배열을 비교하여 볼 개수 반환
│
├── countBallsWithoutDuplicates(int playerNumber, int[] computer, boolean[] checked)
│   └── playerNumber와 computer 배열을 비교하여 중복을 피하고 볼 개수 반환
│
└── resultPrint(int strikes, int balls)
    └── 스트라이크와 볼 개수에 따라 결과를 출력
