import domain.Computer;
import domain.User;
import jdk.jfr.Description;
import jdk.jshell.execution.Util;
import utils.Utils;

import java.util.*;

public class main {
    public static void main(String[] args) {

        while (true) {
            // 1. 컴퓨터가 랜덤으로 서로 다른 값 3개를 골라 순서대로 배열에 저장
            ArrayList<Integer> randNumArray = Computer.makeRandNumArray();

            boolean result = false;

            while (!result) {
                // 2. 사용자가 3개의 숫자 입력, 순서대로 배열에 저장
                ArrayList<Integer> userNumArray = User.inputNumArray();

                // 3. 게임 플레이어가 입력한 숫자에 대한 결과 판별
                result = Utils.showResult(userNumArray, randNumArray);
            }

            // 4. 게임 재시작 여부 선택
            int reStart = Utils.checkReStart();
            if (reStart == 2) {
                break;
            }
        }

    }
}