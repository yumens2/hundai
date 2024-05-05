
public class Application {

    static int[] arr = {0, 0, 0};

    public static void main(String[] args) {

        makeNumber();


    }

    static void makeNumber() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((Math.random() * 10000)
                % 10); // 0~1사이에 난수가 생성되므로 10000을 곱한후 10으로 나눈 나머지로 만든다
            if ((i != 0 && arr[i] == arr[i - 1]) || arr[i] == 0) { // 만든 숫자가 중복되거나 0이면 다시 만든다
                i--;
            }
            if (i == 2 && arr[2] == arr[0]) {
                i--;
            }
        }
    }
}

