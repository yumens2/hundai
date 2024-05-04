# java-baseball-precourse

BaseballNumberGenerator
- generate : 숫자 야구 번호를 생성한다.

GameControlService
- start : 게임을 시작한다.
- printQuestion : "숫자를 입력해 주세요 : "를 출력한다.
- scanInput : 사용자의 입력을 받는다. 입력을 inputNumbers에 쪼개어 넣는다.
- checkInputValid : 사용자의 입력 값이 잘못되었을 경우 IllegalArgumentException를 발생시킨다.
- printRestart : "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." 를 출력한다.
- scanRestart : 1이 입력되면 새로 시작하고, 2을 입력하면 종료된다.

JudgmentService
- compare : 숫자야구 번호와 상대방(컴퓨터)의 수를 비교한다.
- countStrikeBall : strike와 ball 갯수를 센다.
- printCompareResult : 비교 결과를 출력한다.

