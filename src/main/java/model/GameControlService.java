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
    }

    public void printQuestion(){
        System.out.print("숫자를 입력해 주세요 : ");
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

    public void printRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }


}
