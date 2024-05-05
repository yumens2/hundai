import java.util.Scanner;
import java.util.Random;

public class Main {
    static int[] ansList = new int[10];
    static int[] predictList = new int[3];
    public static Scanner scan = new Scanner(System.in);

    static void makeAttack(){
        System.out.print("Input your number: ");
        String predict_Num = scan.nextLine();
        scan.nextLine();
        if (predict_Num.length() == 3){
            makePredict(predict_Num);
        }
        compareAnswer();
    }

    static void makeAns(){
        Random random = new Random();
        for (int order = 1 ; order < 4 ; order++){
            int randomNumber = random.nextInt(10);
            ansList[randomNumber] = order;
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
    }

    static void makePredict(String predict_Num){
        int int_predict_Num = Integer.parseInt(predict_Num);
        predictList[0] = int_predict_Num / 100;
        predictList[1] = (int_predict_Num % 100) / 10;
        predictList[2] = int_predict_Num % 10;
    }

    public static void main(String[] args) {
        makeAns();
        while (true) {
            makeAttack();
        }
    }
}