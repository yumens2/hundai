// 기존 StrikeAndBallCounter 를 BaseballCounter 로 변경하고(추후 요구사항이 변경될 수 있으니)
// recode 클래스로 수정. recode 클래스라는게 있는지 처음 알았는데 이번 기회에 사용해 볼 겸...
public record BaseballCounter(int strikes, int balls) {
}
