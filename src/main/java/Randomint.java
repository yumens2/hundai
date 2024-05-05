import java.util.Random;
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
}