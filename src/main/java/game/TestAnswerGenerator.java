package game;

public class TestAnswerGenerator implements AnswerGenerator {

    private final String answer;

    public TestAnswerGenerator(String predefinedAnswer) {
        answer = predefinedAnswer;
    }

    @Override
    public String getAnswerAsString() {
        return answer;
    }
}
