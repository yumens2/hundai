
import java.util.InputMismatchException;
import java.util.Scanner;

public class BaseBallBE {
    public static void main(String[] args) {
        int[] cpunum = new int[3];
        int[] playernum = new int[3];
        Computer cpu = new Computer();
        Player ply = new Player();
        cpu.RandomThreeNumber(cpunum);
        for(int i = 0; i < cpunum.length; i++){
            System.out.print(cpunum[i]);
        }
        try {
            ply.inputplayernum();
        }catch(IllegalArgumentException e){
            System.out.println(e.toString());
        }
        catch(InputMismatchException a){
            System.out.println("잘못 입력했습니다. 정수만 입력 가능합니다.");
        }
    }
}
