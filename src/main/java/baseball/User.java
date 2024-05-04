package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class User {
    //숫자 입력받기
    public List<Integer> playerNumber() throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        System.out.println("숫자를 입력해 주세요");
        String num=br.readLine();
        List<Integer> playerNumber = new ArrayList<>();
        for(String number: num.split("")){
            playerNumber.add(Integer.parseInt(number));
        }
        return playerNumber;
    }
    public boolean isPossible(List<Integer> playerNumber){
        if(playerNumber.size()!=3){
            throw new IllegalArgumentException("잘못된 숫자를 입력하셨습니다.");
        }
        for(int i=0; i<playerNumber.size(); i++){
            if(!check(playerNumber.get(i),i,playerNumber)){
                throw new IllegalArgumentException("잘못된 숫자를 입력하셨습니다.");
            }
        }
        return true;
    }
    public boolean check(int num, int index, List<Integer> playerNumber){
        for(int i=0; i<playerNumber.size(); i++){
            if(i!=index&&playerNumber.get(i)==num){
                return false;
            }
        }
        return true;
    }
}
