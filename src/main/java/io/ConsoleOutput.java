package io;

public class ConsoleOutput implements Output {
    @Override
    public void printResult(String result) {
        System.out.println(result);
    }

    @Override
    public void printEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }


}
