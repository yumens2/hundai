import java.util.Scanner;
import model.Baseball;
import model.BaseballServiceImpl;

public class Application {

  public static void main(String[] args) {
    Baseball baseball = new Baseball();
    Scanner scanner = new Scanner(System.in);
    BaseballServiceImpl baseballService = new BaseballServiceImpl(baseball, scanner);
    baseballService.play();
  }
}
