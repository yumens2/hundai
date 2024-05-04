package GenerateRandomNumber;

import static GenerateRandomNumber.RandomNumberGeneratorConfigure.LENGTH;
import static GenerateRandomNumber.RandomNumberGeneratorConfigure.MAX_VALUE;
import static GenerateRandomNumber.RandomNumberGeneratorConfigure.MIN_VALUE;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomNumberGenerator {

    // 난수 생성을 위한 Random 객체 생성, private static으로 선언하여 다른 클래스에서 사용 불가 및 static method에서 사용
    private static final Random random = new Random();

    // RandomNumberGeneratorConfigure의 값을 이용하여 난수 생성
    public static List<Integer> generateRandomNumber() {
        List<Integer> generatedNumbers = new LinkedList<>();

        // validationRandomNumber()가 true일 때까지 generate()를 호출하여 난수 생성
        for (generatedNumbers = generate(); !validationRandomNumber(generatedNumbers);
            generatedNumbers = generate())
            ;
        return generatedNumbers;
    }

    // RandomNumberGeneratorConfigure의 MIN_VALUE와 MAX_VALUE 사이의 난수 생성
    private static int randInt() {
        return random.nextInt(MIN_VALUE.getValue(), MAX_VALUE.getValue());
    }

    // RandomNumberGeneratorConfigure의 LENGTH만큼 난수 생성
    private static List<Integer> generate() {
        List<Integer> generateNumbers = new LinkedList<>();
        for (int i = 0; i < LENGTH.getValue(); i++) {
            generateNumbers.add(randInt());
        }
        return generateNumbers;
    }

    // 첫번째 숫자가 0이면 false, 아니면 true 리턴
    private static boolean validationFirstNumber(List<Integer> generatedNumbers) {
        return generatedNumbers.get(0) != 0;
    }

    // 각 숫자들 중, 중복된 값을 확인 및 중복된 값이 없으면 true, 있으면 false 리턴
    private static boolean validationEachNumber(List<Integer> generatedNumbers) {
        Set<Integer> set = new HashSet<>(generatedNumbers);
        return set.size() == generatedNumbers.size();
    }

    // 첫번째 숫자가 0이 아니고, 각 숫자들 중 중복된 값이 없으면 true, 아니면 false 리턴
    private static boolean validationRandomNumber(List<Integer> generatedNumbers) {
        return validationFirstNumber(generatedNumbers) && validationEachNumber(generatedNumbers);
    }
}