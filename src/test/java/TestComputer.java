import java.util.List;

public class TestComputer extends Computer {
    @Override
    public List<Integer> getNumbers() {
        return List.of(1, 2, 3);
    }
}