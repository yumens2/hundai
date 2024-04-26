import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @Test
    @DisplayName("입력 검사(숫자 외 문자)")
    void testInvalidInputNotNumber() {
        String input = "aa\n";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Application app = new Application();
        assertThrows(IllegalArgumentException.class, () -> {
            app.main(new String[0]);
        });
    }

    @Test
    @DisplayName("입력검사(중복숫자)")
    void testInvalidInputDuplicateNumber() {
        String input = "111\n";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Application app = new Application();
        assertThrows(IllegalArgumentException.class, () -> {
            app.main(new String[0]);
        });
    }

    @Test
    @DisplayName("출력검사(모든 경우의 수 대입)")
    void testInvalidInputNumber() {
        List<String> numList = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    if(i==j ||j==k||k==i){
                        continue;
                    }
                    numList.add(String.valueOf(i) + j + k + "\n");
                }
            }
        }

        Application app = new Application();
        String temp = "";
        for (String num : numList) {
            temp+=num;
        }
        System.setIn(new ByteArrayInputStream(temp.getBytes()));

        assertThrows(IllegalArgumentException.class, () -> {
            app.main(new String[0]);
        });
    }

}