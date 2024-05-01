import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import java.util.*;

public class test {

    @Test
    @Description("컴퓨터가 랜덤으로 겹치지 않는 3개의 숫자를 뽑아 순서대로 배열에 저장")
    void makeRandNumArray(){
        ArrayList<Integer> numArray = new ArrayList<>();
        while(numArray.size() < 3){
            Random random = new Random();
            // 1~9 난수 생성
            int n = random.nextInt(8) + 1;
            // 배열에 없는 경우 숫자 추가
            if(!numArray.contains(n)) {
                numArray.add(n);
            }
        }
        for (Integer integer : numArray) {
            System.out.println(integer);
        }
    }

    @Test
    @Description("플레이어가 겹치지 않는 3개의 숫자를 입력해 순서대로 배열에 저장")
    void makeUserNumArray() {
        Scanner scanner = new Scanner(System.in);
//        String nStr = scanner.next(); // 3자리 숫자 입력
        String nStr = "243"; // 테스트 케이스

        char[] charArray = nStr.toCharArray();
        ArrayList<Integer> userNumArray = new ArrayList<>();

        for (char c : charArray) {
            if(checkDuplicate(charArray, c)){ // 중복인 경우 에러 발생시킴
                throw new IllegalArgumentException();
            }
            else{
                userNumArray.add(Integer.parseInt(String.valueOf(c)));
            }
        }

        for (Integer integer : userNumArray) {
            System.out.println(integer);
        }
    }

    @Description("플레이어가 입력한 숫자(현 배열)에서 중복된 문자가 있는지 판별")
    private boolean checkDuplicate(char[] charArray, char c) {
        int cnt = 0;
        for (char c1 : charArray) {
            if(c1 == c){cnt++;}
        }
        if(cnt > 1){ return true;}
        else{return false;}
    }
}
