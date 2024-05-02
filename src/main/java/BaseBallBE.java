
import java.util.InputMismatchException;
import java.util.Scanner;

public class BaseBallBE {
    public static void main(String[] args) {
        int[] cpunum = new int[3];
        int[] playernum = new int[3];
        int[] strikeball = new int[2];
        Computer cpu = new Computer();
        Player ply = new Player();
        StrikeBallChecking sbc = new StrikeBallChecking();
        cpu.RandomThreeNumber(cpunum);
        for(int i = 0; i < cpunum.length; i++){
            System.out.print(cpunum[i]);
        }
        try {
            ply.inputplayernum(playernum);
        }catch(IllegalArgumentException e){
            System.out.println(e.toString());
        }
        for(int i = 0; i < playernum.length; i++){
            System.out.println(playernum[i]);
        }
        sbc.countStrikeBall(cpunum,playernum,strikeball);
        System.out.println(strikeball[0]+"스트라이크, "+strikeball[1]+"볼");
    }
}
