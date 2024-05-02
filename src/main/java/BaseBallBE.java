
import java.util.Scanner;

public class BaseBallBE {
    public static void main(String[] args) {
        int[] cpunum = new int[3];
        int[] playernum = new int[3];
        int num;
        Computer cpu = new Computer();
        Player ply = new Player();
        cpu.RandomThreeNumber(cpunum);
        for(int i = 0; i < cpunum.length; i++){
            System.out.print(cpunum[i]);
        }
        ply.inputplayernum();
    }
}
