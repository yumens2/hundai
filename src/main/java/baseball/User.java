package baseball;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    //유저 번호 입력 받기
    public List<Integer> userNumber() {
        Scanner sc=new Scanner(System.in);
        //BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        System.out.print("숫자를 입력해 주세요 : ");
        String num=sc.next();
        List<Integer> userNumber = new ArrayList<>();
        for(String number: num.split("")){
            if(number.charAt(0)<'1'||number.charAt(0)>'9'){
                throw new IllegalArgumentException("잘못된 숫자를 입력하셨습니다.");
            }
            userNumber.add(Integer.parseInt(number));
        }
        if(!isPossible(userNumber)){
            throw new IllegalArgumentException("잘못된 숫자를 입력하셨습니다.");
        }
        return userNumber;


    }
    //유효 숫자인지
    public boolean isPossible(List<Integer> userNumber){
        if(userNumber.size()!=3){
            throw new IllegalArgumentException("잘못된 숫자를 입력하셨습니다.");
        }
        for(int i=0; i<userNumber.size(); i++){
            if(!check(userNumber.get(i),i,userNumber)){
                throw new IllegalArgumentException("잘못된 숫자를 입력하셨습니다.");
            }
        }
        return true;
    }
    public boolean check(int num, int index, List<Integer> userNumber){
        for(int i=0; i<userNumber.size(); i++){
            if(i!=index&&userNumber.get(i)==num){
                return false;
            }
        }
        return true;
    }
}
