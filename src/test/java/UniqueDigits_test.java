import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class UniqueDigits_test {

    @Test
    public void testUniqueDigits() {
        assertTrue(Application.UniqueDigits("123"));
        assertTrue(Application.UniqueDigits("456"));
        assertTrue(Application.UniqueDigits("789"));
        assertFalse(Application.UniqueDigits("111"));
        assertFalse(Application.UniqueDigits("222"));
        assertFalse(Application.UniqueDigits("333"));
        assertFalse(Application.UniqueDigits("444"));
        assertFalse(Application.UniqueDigits("555"));
        assertFalse(Application.UniqueDigits("666"));
        assertFalse(Application.UniqueDigits("777"));
        assertFalse(Application.UniqueDigits("888"));
        assertFalse(Application.UniqueDigits("999"));
        assertFalse(Application.UniqueDigits("000"));
        assertFalse(Application.UniqueDigits("001"));
        assertFalse(Application.UniqueDigits("010"));
        assertFalse(Application.UniqueDigits("100"));
    }


}
