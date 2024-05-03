public class Application {

    public static void main(String[] args) {
        int qNum[] = makeNum();
    }

    public static int[] makeNum() {
        int num[] = new int[3];
        num[0] = (int)(Math.random() * 10);
        do {
            num[1] = (int)(Math.random() * 10);
        } while(num[0] == num[1]);
        do {
            num[2] = (int)(Math.random() * 10);
        } while(num[0] == num[2] || num[1] == num[2]);
        return num;
    }
}
