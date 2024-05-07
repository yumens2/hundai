package baseball.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class GameRulesTest {

    @Test
    public void testGenerateHint_AllStrikes() {
        GameRules rules = new GameRules();
        String hint = rules.generateHint("123", "123");
        assertThat(hint).isEqualTo("3스트라이크");
    }

    @Test
    public void testGenerateHint_SomeBalls() {
        GameRules rules = new GameRules();
        String hint = rules.generateHint("123", "231");
        assertThat(hint).isEqualTo("3볼");
    }

    @Test
    public void testGenerateHint_Mixed() {
        GameRules rules = new GameRules();
        String hint = rules.generateHint("123", "132");
        assertThat(hint).isEqualTo("2볼 1스트라이크");
    }

    @Test
    public void testGenerateHint_Nothing() {
        GameRules rules = new GameRules();
        String hint = rules.generateHint("123", "456");
        assertThat(hint).isEqualTo("낫싱");
    }

    @Test
    public void testDecideRestart_ReturnsTrueFor1() {
        GameRules rules = new GameRules();
        Boolean result = rules.decideRestart("1");
        assertThat(result).isTrue();
    }

    @Test
    public void testDecideRestart_ReturnsFalseFor2() {
        GameRules rules = new GameRules();
        Boolean result = rules.decideRestart("2");
        assertThat(result).isFalse();
    }

    @Test
    public void testDecideRestart_ReturnsNullForOtherInputs() {
        GameRules rules = new GameRules();
        Boolean result = rules.decideRestart("3");
        assertThat(result).isNull();

        result = rules.decideRestart("hello");
        assertThat(result).isNull();

        result = rules.decideRestart("");
        assertThat(result).isNull();
    }
}