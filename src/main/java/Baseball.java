public class Baseball {
    //야구 게임 전반적인 흐름을 처리
    public static void play(){
        Util myutil = new Util();
        int answer = myutil.generateAnswer(); //숫자 3자리를 생산해냄
        int input;
        while (true) {
            try {
                input = myutil.getInput(); //사용자의 입력값을 받음.
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                break;
            }

        }
    }
}
