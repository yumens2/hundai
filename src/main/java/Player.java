import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {

    public void inputplayernum(int[] playernum) throws IllegalArgumentException {
        int num = 0;
        Scanner sc = new Scanner(System.in);
        DuplicateChecking dc = new DuplicateChecking();
        System.out.print("숫자를 입력해 주세요 : ");
        try {
            num = sc.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("잘못 입력했습니다. 정수만 입력 가능합니다.");
        }
        if (!((num >= 100) && (num <= 999))) {
            throw new IllegalArgumentException("3자리 숫자가 아닙니다.");
        }
        playernum[0] = num / 100;
        num = num % 100;
        playernum[1] = num / 10;
        num = num % 10;
        playernum[2] = num;
        for (int i = 0; i < playernum.length; i++) {
            if (dc.ExistDuplicate(playernum, i)) {
                throw new IllegalArgumentException("중복해서 숫자를 사용하면 안됩니다.");
            }
            if(playernum[i] == 0){
                throw new IllegalArgumentException("0은 사용할 수 없습니다.");
            }
        }
    }
}
