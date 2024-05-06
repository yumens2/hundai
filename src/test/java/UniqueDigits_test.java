import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class UniqueDigits_test {

    @Test
    public void testUniqueDigits() {
        assertTrue(BaseballGame.UniqueDigits("123"));
        assertTrue(BaseballGame.UniqueDigits("456"));
        assertTrue(BaseballGame.UniqueDigits("789"));
        assertFalse(BaseballGame.UniqueDigits("111"));
        assertFalse(BaseballGame.UniqueDigits("222"));
        assertFalse(BaseballGame.UniqueDigits("333"));
        assertFalse(BaseballGame.UniqueDigits("444"));
        assertFalse(BaseballGame.UniqueDigits("555"));
        assertFalse(BaseballGame.UniqueDigits("666"));
        assertFalse(BaseballGame.UniqueDigits("777"));
        assertFalse(BaseballGame.UniqueDigits("888"));
        assertFalse(BaseballGame.UniqueDigits("999"));
        assertFalse(BaseballGame.UniqueDigits("000"));
        assertFalse(BaseballGame.UniqueDigits("001"));
        assertFalse(BaseballGame.UniqueDigits("010"));
        assertFalse(BaseballGame.UniqueDigits("100"));
    }


}
