import java.util.List;

public class TestPlayer extends Player {
    @Override
    public List<Integer> guess() {
        return List.of(4, 5, 6);
    }
}