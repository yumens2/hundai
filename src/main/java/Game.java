public class Game {
    public static void main(String[] args) {
        String compNum = CreateNum.createNumbers();
        String userNum;
        String count;
        int choice = 1;
        boolean answer;

        while (choice == 1) {
            System.out.println("숫자를 입력해주세요 : ");
            try {
                userNum = InputException.inputUserNum();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }

            count = CountNum.CountSB(userNum, compNum);
            answer = PrintInfo.printResult(count);
            if (answer) {
                choice = PrintInfo.userChoice();
                compNum = CreateNum.createNumbers();
            }
        }
    }
}
