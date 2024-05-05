public class Baseball {
    //야구 게임 시작
    public static void play(){
        Util myutil = new Util();
        int answer = myutil.generateAnswer(); //숫자 3자리를 생산해냄
        int input;
        while (true) {
            input = myutil.getInput(); //사용자의 입력값을 받음.
        }
    }
}
