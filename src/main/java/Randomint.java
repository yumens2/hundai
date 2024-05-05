import java.util.Random;
import java.util.Scanner;

public class Randomint {

    int[] randint(int[] arr1) {
        Random random = new Random();
        for (int i=0; i<3;i++) {
            int a= random.nextInt(9)+1;
            arr1[0]= a;
            int b, c;
            do{
                b= random.nextInt(9)+1;
                arr1[1]= b;
            }while(a==b);
            do {
                c= random.nextInt(9)+1;
                arr1[2]= c;
            }while(c==a || c==b);
        }

        for (int i=0; i<3;i++) {
            System.out.print(arr1[i]);
        }


        return arr1;
    }



    int[] myint(int[] arr2) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요 : ");
        int n = scanner.nextInt();
        int n1= n;

        int c2= n%10;
        arr2[2]= c2;
        n/=10;
        int b2= n%10;
        arr2[1]= b2;
        n/=10;
        int a2= n%10;
        arr2[0]= a2;

        intTest(n1,arr2);

        return arr2;
    }


    void intTest(int n, int[] arr2) {
        //숫자 입력 오류시 완전종료

        if (n >999 || n<100) {
            throw new IllegalArgumentException("3자리수가 아닙니다.");
        }
        if (arr2[0]==arr2[1] || arr2[1]==arr2[2] || arr2[0]==arr2[2]) {
            throw new IllegalArgumentException("중복된 숫자입니다.");
        }
        if (arr2[0]==0 || arr2[1]==0 || arr2[2]==0) {
            throw new IllegalArgumentException("1~9 사이의 숫자가 아닙니다.");
        }
    }


}