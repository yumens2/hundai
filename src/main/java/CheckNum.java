import java.util.Arrays;
import java.util.stream.IntStream;

public class CheckNum {
    public int strikeCheck(int[]com, int[]user){
        return IntStream.range(0, GameNum.GAME_NUM.getGameNum())
            .filter(i -> com[i] == user[i])
            .map(i -> 1)
            .sum();
    }
    
    public int ballCheck(int[]com, int[]user){
        return totalCheck(com, user) - strikeCheck(com, user);
    }

    private int totalCheck(int[] com, int[] user) {
        return (int) Arrays.stream(com)
            .filter(num -> Arrays.stream(user).anyMatch(x -> x == num))
            .count();
    }
}
