# java-baseball-precourse
- Functional Requirements
    1. 1부터 9까지의 자연수 중, 중복 없이 3개의 수를 뽑기
    2. 볼과 스트라이크 여부를 정하기
        - 이때 숫자를 정확히 3개 입력해야 한다
        - 3개가 아닌 경우 -> IllegalArgumentException
    3. 3 스트라이크 발생시 ( 숫자 맞춘 경우 ) 재실행 or 종료하기
        - 1을 입력받으면 재실행
        - 2를 입력받으면 종료
        - 이외의 수를 입력받는 경우 -> IllegalArgumentException