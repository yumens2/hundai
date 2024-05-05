package service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import dto.GameResultDTO;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballGameServiceTest {
    BaseballGameService baseballGameServices;
    @BeforeEach
    void setComputer(){
        baseballGameServices = new BaseballGameService();
        baseballGameServices.setNewGame(3, List.of(1,2,3));
    }

    @Test
    @DisplayName("GameResult 반환 테스트")
    void returnGameResultTest(){
        //given
        List<List<Integer>> inputs = List.of(
                List.of(1,2,3),
                List.of(2,3,4),
                List.of(1,3,2),
                List.of(3,5,6),
                List.of(7,8,9)
        );
        List<List<Integer>> outputs = List.of(
                List.of(3, 0),
                List.of(0, 2),
                List.of(1, 2),
                List.of(0, 1),
                List.of(0, 0));
        //when
        List<GameResultDTO> results = inputs
                .stream()
                .map(baseballGameServices::compareNumber)
                .toList();


        //then
        for(int outputIndex = 0; outputIndex < outputs.size(); outputIndex++){
            assertEquals(results.get(outputIndex).getStrike(), outputs.get(outputIndex).get(0));
            assertEquals(results.get(outputIndex).getBall(), outputs.get(outputIndex).get(1));
        }
    }

}