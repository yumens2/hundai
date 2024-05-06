import java.util.Scanner;

public class Input {
    public int getInput() throws IllegalArgumentException{ //사용자의 입력을 받는 함수
        System.out.println("숫자를 입력해 주세요");
        int input;
        Scanner scan = new Scanner(System.in);

        try { //사용자의 입력이 올바르지 않으면 IllegalArgumentException 던짐
            input = scan.nextInt();
        }catch(Exception e){
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다");
        }

        boolean isOK = isValid(input); //사용자의 입력이 중복되지 않은 숫자들로 이루어져 있는지 판단
        if (isOK)
            return input;
        else
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다"); //그렇지 않으면 IllegalArgumentException 던지기
    }

    public boolean isValid(int input){ // 사용자의 입력이 중복되지 않은 숫자들인지 판단하는 함수
        String str = Integer.toString(input);
        if(str.length() != 3)
            return false;
        int[] arr = new int[3];
        arr[0] =Character.getNumericValue(str.charAt(0));
        arr[1] =Character.getNumericValue(str.charAt(1));
        arr[2] =Character.getNumericValue(str.charAt(2));

        if (arr[0]== 0 || arr[1] == 0 || arr[2] ==0) //입력값중에 0이 있는 경우는 비정상
            return false;

        if (arr[0] != arr[1] && arr[0] != arr[2] && arr[1] != arr[2]) //세 숫자가 모두 다른 경우는 정상
            return true;
        else
            return false;
    }
}
