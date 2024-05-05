package participant;

import java.util.Scanner;

public class UserParticipant implements Participant {

    @Override
    public String inputValue() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("1부터 9까지의 숫자 3개를 입력하세요: ");
        String number = scanner.nextLine().trim();

        return number;
    }
}
