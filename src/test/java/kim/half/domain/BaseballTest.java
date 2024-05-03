package kim.half.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class BaseballTest {

    @Test
    public void testConstructorAndGetNumber() {
        Baseball baseball = new Baseball(5);
        assertEquals(5, baseball.getNumber());
    }

    @Test
    public void testEqualsAndHashCode() {
        Baseball baseball1 = new Baseball(3);
        Baseball baseball2 = new Baseball(3);
        Baseball baseball3 = new Baseball(7);

        assertEquals(baseball1, baseball2);
        assertEquals(baseball1.hashCode(), baseball2.hashCode());

        assertNotEquals(baseball1, baseball3);
        assertNotEquals(baseball1.hashCode(), baseball3.hashCode());
    }

    @Test
    public void testInvalidBaseballNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Baseball(0));
        assertThrows(IllegalArgumentException.class, () -> new Baseball(10));
    }
}