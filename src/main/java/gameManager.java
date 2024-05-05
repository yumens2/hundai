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
}
