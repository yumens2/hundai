import VO.Car;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        ArrayList<Car> carList = new ArrayList<>();
        int gameCnt = 0;
        int maxRunCount = 0;
        ArrayList<String> winners = new ArrayList<>();

        /* 자동차 이릅 입력 */
        while(carList.isEmpty()){
            try {
                carList = inputCars();
            }catch (IllegalArgumentException e) {
                System.out.println("[ERROR]차량의 이름이 올바르게 입력되지 않았습니다.") ;
            }catch(Exception e){
                System.out.println("[ERROR]알 수 없는 오류.") ;
                e.printStackTrace();
            }
        }

        /* 경주 횟수 입력 */
        while (gameCnt == 0) {
            try {
                gameCnt = inputGameCnt();
            } catch (Exception e) {
                System.out.println("[ERROR]경주 횟수가 올바르게 입력되지 않았습니다.");
            }
        }

        /* 경주 진행 */
        System.out.println("실행결과");
        for (int i = 0; i < gameCnt; i++) {
            for (Car car:carList) {
                carList.set(carList.indexOf(car), processGame(car));

                /* 우승자 기록 누적 */
                if (car.getRunCount() > maxRunCount) {
                    maxRunCount = car.getRunCount();
                }
            }
            carList.forEach(Application::printResult);
            System.out.println(" ");
        }

        /* 경주 결과 출력 */

        for (Car car:carList) {
            if (car.getRunCount() == maxRunCount) {
                winners.add(car.getCarName());
            }
        }
        System.out.println("최종 우승자 : " + winners);


    }

    /* 차량 입력 및 검증*/
    public static ArrayList<Car> inputCars(){
        ArrayList<Car> carList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carStrings = scanner.nextLine();

        for(String carName:carStrings.split(",")){
            carList.add(new Car(carName));
        }

        for (Car car:carList) {
            if(car.getCarName().length()>5 || car.getCarName().isEmpty()){
                throw new IllegalArgumentException();
            }
        }
        return carList;
    }

    /* 횟수 입력 및 검증*/
    public static int inputGameCnt(){
        int gameCnt;
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇회인가요?");
        gameCnt = scanner.nextInt();
        if(gameCnt<1){
            throw new IllegalArgumentException();
        }
        return gameCnt;
    }

    /* 랜덤으로 전진 칸수 결정 */
    public static int getRunCount(){
        int runCount = 0;
        Random rd = new Random();
        int randomNumber = rd.nextInt(9);
        if(randomNumber >= 4){
            runCount = 1;
        }
        return runCount;
    }

    public static Car processGame(Car car){
        car.addRunCount(getRunCount());
        return car;
    }

    /* 회차별 결과 출력 */
    private static void printResult(Car car) {
        String s = "-";
//        System.out.println(car.getCarName()+ " : " + s.repeat(car.getRunCount()));
        System.out.println(car.getCarName()+ " : " + new String(new char[car.getRunCount()]).replace("\0", s));
    }
}
