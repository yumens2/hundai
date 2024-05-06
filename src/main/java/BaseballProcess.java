import java.util.*;

public class BaseballProcess {

    private List<Integer> randomNumber;
    private Scanner sc = new Scanner(System.in);
    
    // 테스트 용도
    public void setRandomNumber(List<Integer> randomNumber) {
        this.randomNumber = randomNumber;
    }
    public List<Integer> getRandomNumber() {
        return randomNumber;
    }

    public BaseballProcess(){
        restart();
    }

    public void startGame(){
        while(true){
            System.out.print("숫자를 입력해 주세요 : ");
            String input = sc.nextLine();

            List<Integer> guess = parseInput(input);

            int[] result = checkGuess(guess);

            if(result[0] == 3){
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하렬면 2를 입력하세요.");

                String command = sc.nextLine();
                if("2".equals(command)){
                    sc.close();
                    break;
                }
                else{
                    restart();
                }
            }
            else{
                printResult(result[0], result[1]);
            }
        }
    }

    public List<Integer> parseInput(String input){
        List<Integer> number = new ArrayList<>();
        for(char c: input.toCharArray()){
            number.add(Character.getNumericValue(c));
        }

        return number;
    }

    public int[] checkGuess(List<Integer> guess){
        int strike = 0;
        int ball = 0;

        for(int i=0; i<guess.size(); i++){
            if(guess.get(i).equals(randomNumber.get(i))){
                strike += 1;
            }
            else if(randomNumber.contains(guess.get(i))){
                ball += 1;
            }
        }

        return new int[]{strike, ball};
    }

    private void printResult(int strike, int ball){
        if(strike==0 && ball==0){
            System.out.println("낫싱");
        }
        else{
            if(ball>0 && strike>0){
                System.out.printf("%d볼 %d스트라이크\n", ball, strike);
            }
            else if(ball > 0){
                System.out.printf("%d볼\n", ball);
            }
            else if(strike > 0){
                System.out.printf("%d스트라이크\n", strike);
            }
        }
    }

    private void restart(){
        randomNumber = RandomNumberGeneration.randomNumberProduce();
        // System.out.printf("테스트: %s\n", randomNumber.toString());
    }
}