import java.util.Random;

public class Computer {
    public void RandomThreeNumber(int[] cpunum){
        Random rd = new Random();
        for(int i = 0; i < cpunum.length; i++){
            cpunum[i] = rd.nextInt(9)+1;
        }
    }
}
