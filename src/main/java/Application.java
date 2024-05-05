import model.AnalyseBaseballNumber;
import model.BaseballNumberGenerator;
import model.GamePlayer;

public class Application {

    public static void main(String[] args) {
        boolean restart = true;
        int genarateBaseballNumberSize = 3;

        BaseballNumberGenerator baseballNumberGenerator = new BaseballNumberGenerator();
        String computerNumberString;
        AnalyseBaseballNumber analyzer = new AnalyseBaseballNumber();
        GamePlayer gamePlayer = new GamePlayer();

        try {
            while (restart) {
                analyzer.reset();

                computerNumberString = baseballNumberGenerator.generateBaseballNumberString(
                    genarateBaseballNumberSize);
                analyzer.setComputerNumberString(computerNumberString);

                gamePlayer.userActing(genarateBaseballNumberSize, analyzer);

                restart = gamePlayer.gameRestart();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
