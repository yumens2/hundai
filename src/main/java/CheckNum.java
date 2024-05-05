import java.util.stream.IntStream;

public class CheckNum {
    public int strikeCheck(int[]com, int[]user){
        return IntStream.range(1, 1 + GameNum.GAME_NUM.getGameNum())
            .filter(i -> com[i] == user[i])
            .map(i -> 1)
            .sum();
    }
}
