import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Check {
    int[] judgement;
    String com;

    public Check(int[] judgement, String com) {
        this.judgement = judgement;
        this.com = com;
    }

    public void b_s(String num) {
        int com_length = com.length();
        for(int i = 0; i < com_length; i++) {
            for(int j = 0; j < com_length; j++) {
                if(com.charAt(i) == num.charAt(j) && i == j) {
                    this.judgement[1]++;
                } else if(com.charAt(i) == num.charAt(j) && i != j) {
                    this.judgement[0]++;
                }
            }
        }
    }

    public int check_exit() throws IOException {
        int ret = 0;
        if(this.judgement[0] == 0 && this.judgement[1] == 0) {
            System.out.println("낫싱");
        } else if(this.judgement[0] == 0){
            System.out.println(this.judgement[1] + "스트라이크");
        } else if(this.judgement[1] == 0) {
            System.out.println(this.judgement[0] + "볼 ");
        } else if (this.judgement[1] < 3){
            System.out.println(this.judgement[0] + "볼 " + this.judgement[1] + "스트라이크");
        }

        if(this.judgement[1] == 3) {
            this.judgement[0] = 0;
            this.judgement[1] = 0;
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            ret = Integer.parseInt(br.readLine());
        }

        return ret;
    }




}
