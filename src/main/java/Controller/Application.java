package Controller;

import java.io.IOException;

public class Application {
    public static void main(String[] args)throws IOException {
        Game game = new Game();//숫자야구 클래스 객체 생성
        game.run();// 게임 시작
    }
}
