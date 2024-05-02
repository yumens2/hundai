public class Computer {
    private String randNum;         // Random number

    public Computer() {}

    /**
     * Random number 반환
     * @return Random Number
     */
    public String getRandNum() {
        return randNum;
    }

    /**
     * Random number 생성하는 Setter
     */
    public void generateRandNum() {
        boolean[] numList = new boolean[10];
        int cnt = 0;
        int randNum = 0;

        while(cnt < 3) {
            int newNum = (int)(Math.random() * 10);
            if(numList[newNum]) {
                continue;
            }
            numList[newNum] = true;
            randNum = randNum * 10 + newNum;
            cnt++;
        }
        this.randNum = String.format("%03d", randNum);
    }

    public void printInputMessage() {
        System.out.print("숫자를 입력해 주세요 : ");
    }
}
