import jdk.jfr.Description;

import java.util.*;

public class main {
    public static void main(String[] args) {
        try {
            while(true){
                // 1. 컴퓨터가 랜덤으로 서로 다른 값 3개를 골라 순서대로 배열에 저장
                ArrayList<Integer> randNumArray = makeRandNumArray();

                Boolean result = false;

                while(!result){
                    // 2. 사용자가 3개의 숫자 입력, 순서대로 배열에 저장
                    ArrayList<Integer> userNumArray = makeUserNumArray();



                }
            }

        } catch (IllegalArgumentException e) {
            System.out.println("The entered value is invalid. The application will exit.");
        }

    }

//    @Description("플레이어가 겹치지 않는 3개의 숫자를 입력해 순서대로 배열에 저장")
    static ArrayList<Integer> makeUserNumArray() {
        Scanner scanner = new Scanner(System.in);
        String nStr = scanner.next(); // 3자리 숫자 입력

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

        return userNumArray;
    }

//    @Description("플레이어가 입력한 숫자(현 배열)에서 중복된 문자가 있는지 판별")
    private static boolean checkDuplicate(char[] charArray, char c) {
        int cnt = 0;
        for (char c1 : charArray) {
            if(c1 == c){cnt++;}
        }
        if(cnt > 1){ return true;}
        else{return false;}
    }


//    @Description("컴퓨터가 랜덤으로 겹치지 않는 3개의 숫자를 뽑아 순서대로 배열에 저장")
    public static ArrayList<Integer> makeRandNumArray(){
        ArrayList<Integer> numArray = new ArrayList<>();
        while(numArray.size() < 3){
            Random random = new Random();
            int n = random.nextInt(8); // 0~8 난수 생성

            if(!numArray.contains(n)) { // 배열에 없는 경우 숫자 추가
                numArray.add(n);
                System.out.println("rand num = " + n);
            }
        }
        return numArray;
    }
}