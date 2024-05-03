package kim.half.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BaseballsTest {

    @Test
    public void testConstructorAndSizeAndGet() {
        List<Baseball> baseballList = new ArrayList<>();
        baseballList.add(new Baseball(1));
        baseballList.add(new Baseball(2));
        baseballList.add(new Baseball(3));

        Baseballs baseballs = new Baseballs(baseballList);

        assertEquals(3, baseballs.size());
        assertEquals(1, baseballs.get(0).getNumber());
        assertEquals(2, baseballs.get(1).getNumber());
        assertEquals(3, baseballs.get(2).getNumber());
    }

    @Test
    public void testCountStrike() {
        List<Baseball> baseballList1 = new ArrayList<>();
        baseballList1.add(new Baseball(1));
        baseballList1.add(new Baseball(2));
        baseballList1.add(new Baseball(3));

        List<Baseball> baseballList2 = new ArrayList<>();
        baseballList2.add(new Baseball(1));
        baseballList2.add(new Baseball(5));
        baseballList2.add(new Baseball(3));

        Baseballs baseballs1 = new Baseballs(baseballList1);
        Baseballs baseballs2 = new Baseballs(baseballList2);

        assertEquals(2, baseballs1.countStrike(baseballs2));
    }

    @Test
    public void testCountBall() {
        List<Baseball> baseballList1 = new ArrayList<>();
        baseballList1.add(new Baseball(1));
        baseballList1.add(new Baseball(2));
        baseballList1.add(new Baseball(3));

        List<Baseball> baseballList2 = new ArrayList<>();
        baseballList2.add(new Baseball(4));
        baseballList2.add(new Baseball(1));
        baseballList2.add(new Baseball(5));

        Baseballs baseballs1 = new Baseballs(baseballList1);
        Baseballs baseballs2 = new Baseballs(baseballList2);

        assertEquals(1, baseballs1.countBall(baseballs2));
    }

    @Test
    public void testEqualsAndHashCode() {
        List<Baseball> baseballList1 = new ArrayList<>();
        baseballList1.add(new Baseball(1));
        baseballList1.add(new Baseball(2));
        baseballList1.add(new Baseball(3));

        List<Baseball> baseballList2 = new ArrayList<>();
        baseballList2.add(new Baseball(1));
        baseballList2.add(new Baseball(2));
        baseballList2.add(new Baseball(3));

        List<Baseball> baseballList3 = new ArrayList<>();
        baseballList3.add(new Baseball(4));
        baseballList3.add(new Baseball(5));
        baseballList3.add(new Baseball(6));

        Baseballs baseballs1 = new Baseballs(baseballList1);
        Baseballs baseballs2 = new Baseballs(baseballList2);
        Baseballs baseballs3 = new Baseballs(baseballList3);

        assertEquals(baseballs1, baseballs2);
        assertEquals(baseballs1.hashCode(), baseballs2.hashCode());

        assertNotEquals(baseballs1, baseballs3);
        assertNotEquals(baseballs1.hashCode(), baseballs3.hashCode());
    }

    @Test
    public void testInvalidSizeConstructor() {
        List<Baseball> baseballList = new ArrayList<>();
        baseballList.add(new Baseball(1));
        baseballList.add(new Baseball(2));

        assertThrows(IllegalArgumentException.class, () -> new Baseballs(baseballList));
    }
}