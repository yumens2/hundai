public class InitNumbers {

    private String numbers = "";

    public InitNumbers() {
        boolean[] checked = new boolean[10];

        while (this.numbers.length() < 3) {
            int temp = (int) ((Math.random() * 10000) % 10);

            if (!checked[temp]) {
                checked[temp] = true;
                this.numbers += Integer.toString(temp);
            }
        }
    }

    public String getNumbers() {
        return numbers;
    }
}
