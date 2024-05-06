public class Applicaiton {
    public static void main(String[] args) {
        while(true) {
            boolean again; //사용자가 답을 맞춘뒤에 다시 게임을 할지 안할지 여부를 저장하는 변수
            again = Baseball.play();
            if(again) //계속하고자 하면 다시 continue 진행
                continue;
            else //그만하고자 하면 application 종료
                break;
        }
    }
}
