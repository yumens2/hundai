# java-baseball-precourse

# 설계

- Controller
  - BaseBallController
- View
  - InputView : 입력 관련 뷰
  - OutputView : 출력 관련 뷰
- Domain
  - Player : 자신이 내놓은 숫자에 대한 정보를 안다.
  - Score : 주어진 Player에 대한 점수를 판단한다.
  - Service
    - BaseBallService : BaseBall 비즈니스 로직과 관련된 처리