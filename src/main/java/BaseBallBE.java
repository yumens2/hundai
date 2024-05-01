
import java.util.Scanner;

public class BaseBallBE {
    public static void main(String[] args) {
        int[] cpunum = new int[3];
        Computer cpu = new Computer();
        cpu.RandomThreeNumber(cpunum);
        for(int i = 0; i < cpunum.length; i++){
            System.out.println(cpunum[i]);
        }
    }
}
