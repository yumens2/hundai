package kim.half.service;

import kim.half.ui.OutputBuilder;

public class ResumeChecker {

    private static final int VALID_OPINION_INPUT_SIZE = 1;
    private static final int RESUME_REPLY = 1;
    private static final int STOP_REPLY = 2;
    private static final char ZERO_CHAR = '0';

    private final int opinion;

    public ResumeChecker(String userReply) {
        isValidLength(userReply);

        this.opinion = userReply.charAt(0) - ZERO_CHAR;
        isValidOpinionRange(opinion);
    }

    private void isValidLength(String userReply) {
        if (userReply.length() != VALID_OPINION_INPUT_SIZE) {
            throw new IllegalArgumentException(OutputBuilder.RESUME_INPUT_SIZE_EXCEPTION_MESSAGE);
        }
    }

    private void isValidOpinionRange(int opinion) {
        if ((opinion != RESUME_REPLY) && (opinion != STOP_REPLY)) {
            throw new IllegalArgumentException(OutputBuilder.RESUME_INPUT_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    public boolean isResume() {
        return (opinion == RESUME_REPLY);
    }
}
