import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {
    static int[] ansList;
    @DisplayName("배열 초기화 테스트")
    @Test
    void initList() {
        ansList = new int[10];
        assertThat(ansList.length).isEqualTo(10);
    }
    @DisplayName("입력한 값 배열 변환 테스트")
    @Test
    void makePredict() {
        String predict_Num = "123";
        int[] predictList = new int[3];
        int int_predict_Num = Integer.parseInt(predict_Num);
        predictList[0] = int_predict_Num / 100;
        predictList[1] = (int_predict_Num % 100) / 10;
        predictList[2] = int_predict_Num % 10;

        assertThat(predictList.length).isEqualTo(3);
    }
}