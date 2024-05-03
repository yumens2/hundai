package kim.half.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BaseballFactoryTest {

    @Test
    public void testGenerateRandomBaseballs() {
        Baseballs baseballs = BaseballFactory.generateRandomBaseballs();
        assertNotNull(baseballs);
        assertEquals(3, baseballs.size());
    }

    @Test
    public void testCreateBaseballs() {
        String baseballNumbers = "123";
        Baseballs baseballs = BaseballFactory.createBaseballs(baseballNumbers);
        assertNotNull(baseballs);
        assertEquals(3, baseballs.size());
        assertEquals(1, baseballs.get(0).getNumber());
        assertEquals(2, baseballs.get(1).getNumber());
        assertEquals(3, baseballs.get(2).getNumber());
    }

    @Test
    public void testCreateRandomBaseballs() {
        Baseballs baseballs = BaseballFactory.createRandomBaseballs();
        assertNotNull(baseballs);
        assertEquals(3, baseballs.size());
        assertTrue(baseballs.get(0).getNumber() >= 1 && baseballs.get(0).getNumber() <= 9);
        assertTrue(baseballs.get(1).getNumber() >= 1 && baseballs.get(1).getNumber() <= 9);
        assertTrue(baseballs.get(2).getNumber() >= 1 && baseballs.get(2).getNumber() <= 9);
        assertNotEquals(baseballs.get(0).getNumber(), baseballs.get(1).getNumber());
        assertNotEquals(baseballs.get(0).getNumber(), baseballs.get(2).getNumber());
        assertNotEquals(baseballs.get(1).getNumber(), baseballs.get(2).getNumber());
    }
}