package Model;

public class Computer {
    private static boolean[] visited;
    private Computer(){}

    public static String makeRandomNumber(){//쉽게 볼과 스트라이크를 판단하기위해 String으로 리턴
        visited = new boolean[10];//중복 확인 배열
        StringBuilder sb = new StringBuilder();//숫자를 만들기 위한 StringBuilder
        for(int i = 0; i < 3; i++){//3자리수 이므로 3번 반복
            sb.append(randomNumber());
        }
        return sb.toString();
    }
    private static int randomNumber(){//랜덤한 중복되지 않는 수 리턴
        int nowNumber = (int)((Math.random()*9)+1);//현재 수
        while(visited[nowNumber]){//이미 썼던 수면 다시 뽑기
            nowNumber = (int)((Math.random()*9)+1);
        }
        visited[nowNumber] = true;//쓸것이므로 true로 바꿈
        return nowNumber;
    }
}
