import model.BaseballNumberGenerator;

public class Application {

    public static void main(String[] args) {
        int genarateBaseballNumberSize = 3;

        BaseballNumberGenerator baseballNumberGenerator = new BaseballNumberGenerator();
        String baseballNumberString = baseballNumberGenerator.generateBaseballNumberString(genarateBaseballNumberSize);

        System.out.println(baseballNumberString);
    }
}
