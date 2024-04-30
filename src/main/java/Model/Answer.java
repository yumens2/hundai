package Model;

public class Answer {
    private String answerNum;//컴퓨터가 생성한 정답

    public Answer(String answerNum){//생성자로 초기화
        this.answerNum = answerNum;
    }

    public String getAnswerNum() {//getter로만 접근가능
        return answerNum;
    }
}
