package model;

import java.util.ArrayList;
import java.util.Scanner;

public class GameControlService {
    private Scanner scanner;
    private ArrayList<Integer> targetNumbers;
    private ArrayList<Integer> inputNumbers;
    public GameControlService(){
        scanner = new Scanner(System.in);
    }

    public void start(){
        BaseballNumberGenerator baseballNumberGenerator = new BaseballNumberGenerator();
        JudgmentService judgmentService = new JudgmentService();
        targetNumbers = baseballNumberGenerator.generate();
        while(true){
            System.out.print("숫자를 입력해 주세요 : ");
            scanInput();
            Score score = judgmentService.compare(targetNumbers, inputNumbers);
            printScore(score);
            if(score.getStrike() == BaseballNumberGenerator.making_number_count){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    public void scanInput(){
        String input = scanner.nextLine();
        try {
            checkInputValid(input);
        }catch(Exception e){
           System.exit(-1);
        }
        inputNumbers = new ArrayList<Integer>();
        for(int i = 0; i < input.length(); i++){
            inputNumbers.add(Integer.parseInt(String.valueOf(input.charAt(i))));
        }
    }

    public void checkInputValid(String input) throws IllegalArgumentException{
        if(input.length() != BaseballNumberGenerator.making_number_count){
            throw new IllegalArgumentException("Invalid Input : " + input);
        }
    }

    public GameControlService scanRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int checkRestart = Integer.parseInt(scanner.nextLine());
        if(checkRestart == 1){
            GameControlService gameControlService = new GameControlService();
            return gameControlService;
        }
        else if(checkRestart == 2) {
            return null;
        }
        else
            throw new IllegalArgumentException("Invalid Input : " + checkRestart);
    }

    public void printScore(Score score){
        if(score.getStrike() == 0 && score.getBall() == 0)
            System.out.println("낫싱");
        else{
            if(score.getStrike()!=0)
                System.out.print(score.getStrike() + "스트라이크 ");
            if(score.getBall()!=0)
                System.out.print(score.getBall() + "볼 ");
            System.out.println();
        }
    }
}
