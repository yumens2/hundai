import java.util.List;

public class Compare {
    // userinput = list , random = stringBuilder
    public int contain(List<String> player, StringBuilder computer) {
        int count = 0;
        for (String str : player) {
            if (computer.indexOf(str) != -1) {
                count++;
            }
        }
        return count;
    }

    public int strike(List<String> player, StringBuilder computer) {
        int strike_count = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.charAt(i) == player.get(i).charAt(0)) {
                strike_count += 1;
            }
        }
        return strike_count;
    }

}
