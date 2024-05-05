package service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameServiceTest {
    @Test
    @DisplayName("countBall test")
    void countBallTest() throws Exception {
        //given
        ITestGameService service = new GameService();
        int[] testUserNumbers = {1, 2, 3};
        int[] testComputerNumbers = {3, 2, 1};

        //when
        service.countBall(testUserNumbers, testComputerNumbers);

        //then
        assertThat(service.getBallCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("countStrike test")
    void countStrikeTest() throws Exception {
        //given
        ITestGameService service = new GameService();
        int[] testComputerNumbers = {3, 2, 1};
        int[] test1UserNumbers = {1, 2, 3};
        int[] test2UserNumbers = {5, 4, 3};

        //when1
        service.countBall(test1UserNumbers, testComputerNumbers);
        service.countStrike(test1UserNumbers, testComputerNumbers);

        //then1
        assertThat(service.getStrikeCount()).isEqualTo(1);
        assertThat(service.getBallCount()).isEqualTo(2);

        //when2
        service.countBall(test2UserNumbers, testComputerNumbers);
        service.countStrike(test2UserNumbers, testComputerNumbers);

        //then2
        assertThat(service.getStrikeCount()).isEqualTo(0);
        assertThat(service.getBallCount()).isEqualTo(1);
    }

}