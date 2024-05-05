package src.main.java.problem;

public abstract class ValueChecker {
    private final String problemValue;
    private ProvidedMessage providedMessage;

    public ValueChecker(String problemValue) {
        this.problemValue = problemValue;
    }

    public String determineTheValue(String inputValue) {
        return null;
    }
}
