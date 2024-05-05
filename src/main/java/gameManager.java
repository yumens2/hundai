import java.util.Random;

public class gameManager {

    public void startGame() {
        int[] randNum = generateRand();

        try {
            int[] userNum = getInput();

            while (!computBallCount(randNum, userNum)) {
                userNum = getInput();
            }

            if (gameMenu()) {
                startGame();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    private int[] generateRand() {
        Random random = new Random();
        int[] generatedRandNum = new int[3];

        generatedRandNum[0] = random.nextInt(1, 10);
        generatedRandNum[1] = generatedRandNum[0];
        generatedRandNum[2] = generatedRandNum[0];
        while (generatedRandNum[1] == generatedRandNum[0]) {
            generatedRandNum[1] = random.nextInt(1, 10);
        }
        while (generatedRandNum[2] == generatedRandNum[0]
            || generatedRandNum[2] == generatedRandNum[1]) {
            generatedRandNum[2] = random.nextInt(1, 10);
        }

        return generatedRandNum;
    }
}
