package kim.half.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ResumeCheckerTest {

    @Test
    void testConstructorWithValidInput() {
        // Test
        ResumeChecker resumeChecker = new ResumeChecker("1");

        // Verify
        assertNotNull(resumeChecker);
    }

    @Test
    void testConstructorWithInvalidInputSize() {
        // Test and Verify
        assertThrows(IllegalArgumentException.class, () -> new ResumeChecker("12"));
    }

    @Test
    void testConstructorWithInvalidOpinionRange() {
        // Test and Verify
        assertThrows(IllegalArgumentException.class, () -> new ResumeChecker("3"));
    }

    @Test
    void testIsResumeWithResumeReply() {
        // Arrange
        ResumeChecker resumeChecker = new ResumeChecker("1");

        // Test and Verify
        assertTrue(resumeChecker.isResume());
    }

    @Test
    void testIsResumeWithStopReply() {
        // Arrange
        ResumeChecker resumeChecker = new ResumeChecker("2");

        // Test and Verify
        assertFalse(resumeChecker.isResume());
    }
}
