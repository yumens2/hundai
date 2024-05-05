import java.security.SecureRandom;
public class Random {
    private static final SecureRandom random = new SecureRandom();
    
    // 1 ~ 9까지의 수중에서 랜덤으로 뽑아서 서로 다른 3자리 만드는 메서드.
    public static int getRandomNumber() {
        int digit1 = random.nextInt(9) + 1; // 1부터 9까지의 랜덤숫자
        int digit2;
        int digit3;
        do {
            digit2 = random.nextInt(9) + 1;
        } while (digit2 == digit1); // 첫 번째 숫자와 중복되지 않게
        do {
            digit3 = random.nextInt(9) + 1; 
        } while (digit3 == digit1 || digit3 == digit2); // 숫자1,2중에 하나라도 중복되면
        
        int randomNumber = digit1 * 100 + digit2 * 10 + digit3; // 3자리 수 만들기.
        
        return randomNumber;
    }
}
