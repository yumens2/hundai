import java.util.Scanner;
import java.util.Random;

public class Main {
    static int is_reGame;
    static int[] ansList;
    static int[] predictList = new int[3];
    public static Scanner scan = new Scanner(System.in);

    static void initList(){
        ansList = new int[10];
        is_reGame = 0;
    }

    static void makeAttack(){
        while (true){
            System.out.print("Input number: ");
            String predict_Num = scan.nextLine();
            try {
                makePredict(predict_Num);
                compareAnswer();
            } catch (IllegalArgumentException e) {
                System.out.println("Caught IllegalArgumentException: " + e.getMessage());
                is_reGame = 2;
            }
            if (is_reGame != 0){
                break;
            }
        }
    }

    static void makeAns(){
        Random random = new Random();
        int order = 1;
        while (order < 4){
            int randomNumber = random.nextInt(10);
            if (ansList[randomNumber] == 0){
                ansList[randomNumber] = order;
                order ++;
            }
        }
    }

    static void compareAnswer(){
        int[] resultCount = new int[3];
        for (int order = 1; order < 4 ; order++){
            if (ansList[predictList[order-1]] == order) {
                resultCount[0] += 1;
            } else if (ansList[predictList[order-1]] != 0){
                resultCount[1] += 1;
            } else {
                resultCount[2] += 1;
            }
        }
        printCompareResult(resultCount);
    }
    static void makePredict(String predict_Num){
        if (predict_Num.length() != 3){
            throw new IllegalArgumentException("input size must be 3");
        }
        int int_predict_Num = Integer.parseInt(predict_Num);
        predictList[0] = int_predict_Num / 100;
        predictList[1] = (int_predict_Num % 100) / 10;
        predictList[2] = int_predict_Num % 10;
    }

    static void printCompareResult(int[] resultCount ){
        if (resultCount[2] == 3){
            System.out.print("nothing");
        }
        if (resultCount[0] != 0) {
            System.out.print(resultCount[0]+"strike ");
        }
        if (resultCount[1] != 0) {
            System.out.print(resultCount[1]+"ball ");
        }
        System.out.println();
        if (resultCount[0] == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            is_reGame = scan.nextInt();
            scan.nextLine();
        }
    }

    public static void main(String[] args) {
        while (true){
            initList();
            makeAns();
            makeAttack();
            if (is_reGame == 2){
                break;
            }
        }
    }
}