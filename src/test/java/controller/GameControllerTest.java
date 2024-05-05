package controller;

import model.Computer;
import model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {
    User user = new User();
    Computer computer = new Computer();
    GameController gameController = new GameController(user, computer);

    @Test
    void setUserNumbers() {
        // Given
        ArrayList<Integer> expectedNumbers = new ArrayList<>(Arrays.asList(1, 2, 3));
        GameController gameController = new GameController(user, computer);

        // When
        String input = "1 2 3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        gameController.setUserNumbers();

        // Then
        Assertions.assertThat(user.getNumberList()).isEqualTo(expectedNumbers);
    }
    //
    // @Test
    // void setComputerNumbers() {
    //     // Given
    //     Set<Integer> expectedNumbers = new LinkedHashSet<>();
    //     expectedNumbers.add(1);
    //     expectedNumbers.add(2);
    //     expectedNumbers.add(3);
    //
    //     // When
    //     gameController.setComputerNumbers();
    //
    //     // Then
    //     Assertions.assertThat(computer.getNumberSet().size()).isEqualTo(expectedNumbers.size());
    // }
}
