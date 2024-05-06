package controller;

import model.BallCountStatus;
import model.Computer;
import model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ScoreControllerTest {
    ScoreController scoreController = new ScoreController();
    InputController inputController = new InputController();


    @Test
    void compareScoreBall() {
        ArrayList<BallCountStatus> inputStatus = new ArrayList<>(); // empty score board
        User user = new User();

        Computer computer = new Computer();
        Set<Integer> computerNumbers = new LinkedHashSet<>();
        computerNumbers.add(1);
        computerNumbers.add(2);
        computerNumbers.add(3);
        computer.setNumberSet(computerNumbers);

        String expectedUserNum = "3 1 2";
        System.setIn(new ByteArrayInputStream(expectedUserNum.getBytes()));
        user.setNumberList(inputController.generateUserNum());

        scoreController.compareScoreBall(inputStatus, user, computer);

        assertThat(inputStatus.size()).isEqualTo(3);
        for (BallCountStatus status : inputStatus) {
            assertThat(status).isEqualTo(BallCountStatus.Ball);
        }
    }

    @Test
    void compareScoreStrike() {
        ArrayList<BallCountStatus> inputStatus = new ArrayList<>(); // empty score board
        User user = new User();

        Computer computer = new Computer();
        Set<Integer> computerNumbers = new LinkedHashSet<>();
        computerNumbers.add(1);
        computerNumbers.add(2);
        computerNumbers.add(3);
        computer.setNumberSet(computerNumbers);

        String expectedUserNum = "1 2 3";
        System.setIn(new ByteArrayInputStream(expectedUserNum.getBytes()));
        user.setNumberList(inputController.generateUserNum());

        scoreController.compareScoreStrike(inputStatus, user, computer);

        assertThat(inputStatus.size()).isEqualTo(3);
        for (BallCountStatus status : inputStatus) {
            assertThat(status).isEqualTo(BallCountStatus.Strike);
        }
    }

    @Test
    @DisplayName("OneBall OneStrike")
    void testConvertScoreListToStringOneBallOneStrike() {
        // given
        String expected = "1볼 1스트라이크";
        ArrayList<BallCountStatus> myScore = new ArrayList<>();
        myScore.add(BallCountStatus.Ball);
        myScore.add(BallCountStatus.Strike);
        myScore.add(BallCountStatus.Ball);
        ScoreController scoreController = new ScoreController();

        // when
        String result = scoreController.convertScoreListToString(myScore);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("ThreeStrike")
    void testConvertScoreListToStringThreeStrike() {
        // given
        String expected = "3스트라이크";
        ArrayList<BallCountStatus> myScore = new ArrayList<>();
        myScore.add(BallCountStatus.Strike);
        myScore.add(BallCountStatus.Strike);
        myScore.add(BallCountStatus.Strike);
        ScoreController scoreController = new ScoreController();

        // when
        String result = scoreController.convertScoreListToString(myScore);

        // then
        assertThat(result).isEqualTo(expected);
    }
    @Test
    @DisplayName("ThreeBall")
    void testConvertScoreListToStringThreeBall() {
        // given
        String expected = "3볼";
        ArrayList<BallCountStatus> myScore = new ArrayList<>();
        myScore.add(BallCountStatus.Ball);
        myScore.add(BallCountStatus.Ball);
        myScore.add(BallCountStatus.Ball);
        ScoreController scoreController = new ScoreController();

        // when
        String result = scoreController.convertScoreListToString(myScore);

        // then
        assertThat(result).isEqualTo(expected);
    }
    @Test
    @DisplayName("Nothing")
    void testConvertScoreListToStringNothing() {
        // given
        String expected = "낫싱";
        ArrayList<BallCountStatus> myScore = new ArrayList<>();
        ScoreController scoreController = new ScoreController();

        // when
        String result = scoreController.convertScoreListToString(myScore);

        // then
        assertThat(result).isEqualTo(expected);
    }


}
