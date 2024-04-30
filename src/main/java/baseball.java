import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Vector;
import java.util.Random;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;


public class baseball {
    public static void main(String[] args) {
        int[] computer = {0, 0, 0};
        comNum(computer);

        int resume = 0, flag = 0;
        Integer[] userNumber = {0, 0, 0};
        while (resume == 0) {
            gameStart();
            flag = detectError(userNumber);
            if (flag == 2) {
                break;
            }
            resume = ball_strike(userNumber, computer);
            if(resume == 1){
                comNum(computer);
                resume = 0;
            }
        }

        System.out.println("Program is Quit");
    }

    public static void comNum(int[] computer) {
        Random random = new Random();
        Vector<Integer> number = new Vector<>();
        for(int i=1; i<10; i++) {
            number.add(i);
        }
        int buffer;

        buffer = random.nextInt(9); // 0~8 random index
        computer[0] = number.get(buffer); // select num(w.random index) and save in computer vector
        number.remove(buffer); //remove for prevent reduplication

        buffer = random.nextInt(8); // 0~7 random index
        computer[1] = number.get(buffer);
        number.remove(buffer); //remove for prevent reduplication

        buffer = random.nextInt(7); // 0~6 random index
        computer[2] = number.get(buffer);

        for(int i : computer) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static void gameStart() {
        System.out.print("predict enemy's number : ");
    }

    public static void splitInteger(int user, Integer[] userNumber) {
        int remain;
        for(int i=0; i<3; i++) {
            remain = user % 10;
            userNumber[2-i] = remain;
            user = user/10;
        }
    }

    public static int detectError(Integer[] userNumber) {
        Scanner scan = new Scanner(System.in);
        int user;

        try {
            user = scan.nextInt();
            splitInteger(user, userNumber);
            Set<Integer> set = new HashSet<>(Arrays.asList(userNumber));
            if (String.valueOf(user).length() != 3 || set.size() != 3) {
                throw new IllegalArgumentException("Exeption: Not a three-digit integer or redundant number.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Exeption: Not an integer.");
            return 2;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return 2;
        }
        return 0;
    }

    public static int resumeGame(){
        System.out.println("You guessed all 3 numbers correctly! Game Over");
        System.out.println("Enter 1 to start a new game, or 2 to quit.");

        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static int[] compareNum(int i, int j, int userIndex, int comIndex) {
        int[] numbers = {0, 0};

        if (i==j) {
            if (userIndex == comIndex) {
                numbers[0] += 1;
            }
            else {
                numbers[1] += 1;
            }
        }

        return numbers;
    }

    public static int ball_strike(Integer[] userNumber, int[] com){
        int strike = 0, ball = 0, userIndex = 0, comIndex = 0;

        for (int i : userNumber){
            for (int j : com) {
                int[] numbers = compareNum(i, j, userIndex, comIndex);
                strike += numbers[0];
                ball += numbers[1];
                comIndex += 1;
            }
            userIndex += 1;
            comIndex = 0;
        }
        if(strike==0 & ball==0){
            System.out.println("Out!!");
            return 0;
        }
        else if(strike==3){
            System.out.println("3Strike");
            return resumeGame();
        }
        else{
            System.out.printf("%dBall %dStrike \n", ball, strike);
            return 0;
        }
    }
}
