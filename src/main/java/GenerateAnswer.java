import java.util.Random;

public class GenerateAnswer {
    public int generateAnswer(){ // 숫자 3자리를 만들어내는 함수
        Random random =new Random();
        int [] Answer = new int[3]; // 사용자가 맞춰야 하는 정답을 담는 int 배열
        int temp;
        Answer[0]=random.nextInt(8)+1; //첫 번째 숫자 생성

        while(true) { //두번째 숫자는 1번째 숫자와 다른 값이 오게끔
            temp = random.nextInt(8)+1;
            if (Answer[0] == temp)
                continue;
            else
                break;
        }
        Answer[1] = temp;

        while(true) { //세번째 숫자는 1,2번째 숫자와 다른 값이 오게끔
            temp = random.nextInt(8)+1;
            if (Answer[0] == temp || Answer[1] == temp)
                continue;
            else
                break;
        }
        Answer[2] = temp;

        String str = ""+Answer[0]+Answer[1]+Answer[2]; //
        return Integer.parseInt(str);
    }
}
