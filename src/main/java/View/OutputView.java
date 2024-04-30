package View;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputView {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private OutputView(){}

    public static void output(String message)throws IOException {//개행없이 매개변수 출력
        bw.write(message);
        bw.flush();
    }

    public static void outputLine(String message)throws IOException {//개행있이 매개변수 출력
        bw.write(message+"\n");
        bw.flush();
    }

    public static void outputInputNumber()throws IOException{//숫자를 입력해야할때 멘트 출력
        bw.write("숫자를 입력해 주세요 : ");
        bw.flush();
    }

    public static void outputFinish()throws IOException{//게임이 종료 될때 멘트 출력
        bw.write("3개의 숫자를 모두 맞히셨습니다! 게임종료\n");
        bw.flush();
    }

    public static void outputRestart()throws IOException{//게임 재시작 여부 멘트 출력
        bw.write("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        bw.flush();
    }
}
