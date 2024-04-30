# ⚾️ java-baseball-precourse
- [Description](#description)
- [Function(feature)](#function(feature))
  - [1. generate random number](#1-generate-random-number)
  - [2. input number](#2-input-number)
  - [3. compare number](#3-compare-number)
  - [4. print compare result](#4-print-compare-result)
  - [5. game end or restart](#5-game-end-or-restart)
- [Exception](#exception)
  - [Number Input exception while game is running](#number-input-exception-while-game-is-running)
  - [Game restart exception after game is over](#game-restart-exception-after-game-is-over)

## Description
- 1~9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 숫자 야구 게임

## Function(feature)
- feature 단위로 작성
- commit 시 `BASEBALL-feature#` 형식으로 작성

### 1. generate random number
- 1~9까지 서로 다른 수로 이루어진 3자리의 수를 생성

### 2. input number
- 1~9까지 서로 다른 수로 이루어진 3자리의 수를 입력
- **입력 예외 처리**(예외 발생 시 프로그램 종료)
  - 1~9까지의 숫자가 아닌 경우
  - 3자리의 숫자가 아닌 경우
  - 중복된 숫자가 입력된 경우

### 3. compare number
- 입력한 숫자와 생성된 숫자를 비교하여 결과를 반환
- 비교 결과 type
  1. 자리 • 숫자 모두 맞는 경우 : `스트라이크`
  2. 숫자만 맞는 경우 : `볼`
  3. 모든 자릿수가 틀린 경우 : `낫싱`

### 4. print compare result
- 비교 결과를 출력한다.
- 이때, 낫싱이 아닌 경우 볼 -> 스트라이크 순서로 출력할 수 있도록 한다. (e.g. 스트라이크 1개, 볼 1개인 경우 `1볼 1스트라이크`)
- 모든 자릿수를 맞춘 경우 축하 문구(`3개의 숫자를 모두 맞히셨습니다! 게임 종료`)를 출력한다.
- 모든 자릿수를 맞추지 못한 경우, 다시 숫자를 입력 받고 비교하는 일련의 과정을 반복한다.

### 5. game end or restart
- 모든 자릿수를 맞춘 경우 게임 재시작 여부를 묻는다.
- **입력 예외 처리**(예외 발생 시 프로그램 종료)
  - 1 또는 2가 아닌 경우

## Exception
- 예외 발생 시 프로그램 종료
### Number Input exception while game is running
- `NonNumericValueException` : 1~9까지의 숫자가 아닙니다.
- `InvalidLengthException` : 3자리의 숫자가 아닙니다.
- `DuplicateNumberException` : 중복된 숫자가 입력되었습니다.

### Game restart exception after game is over
- `InvalidRestartStateException` : 1 또는 2가 아닙니다.

