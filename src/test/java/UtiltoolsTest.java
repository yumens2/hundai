import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtiltoolsTest {

    @Test
    //string to int array
    void changeType() {
        int[] returnBuffer = {0, 0, 0};
        int[] result = {1, 2, 3};
        String userNum = "123";
        Utiltools util = new Utiltools();

        util.changeType(returnBuffer, userNum);
        assertArrayEquals(returnBuffer, result);
    }

    @Test
    //compare userNum int array, computerNum int array
    //if only index equal result[0] += 1
    //if index and value equal result[1] += 1
    //there is no equal result[2] += 1
    void compareNum() {
        int[] computerNumber = {1, 2, 3};
        int[] userNumber = {1, 3, 4};
        int[] returnBuffer = {0, 0, 0};
        int[] result = {1, 1, 7};
        Utiltools util = new Utiltools();

        util.compareNum(computerNumber, userNumber, returnBuffer);
        assertArrayEquals(returnBuffer, result);
    }

    @Test
    //check array intialize 0
    void clearResult() {
        int[] resultBuffer = {1, 2, 3};
        int[] result = {0, 0, 0};
        Utiltools util = new Utiltools();

        util.clearResult(resultBuffer);
        assertArrayEquals(resultBuffer, result);
    }
}