public class Compare {

    private int strikes=0;
    private int balls=0;


    public void compare(int[] targetNumbers, int[] playerInput){

        for (int i = 0; i < 3; i++) {
            if (targetNumbers[i] == playerInput[i]) {
                this.strikes++;
            } else if (containsNumber(targetNumbers, playerInput[i])) {
                this.balls++;
            }
        }

        if(this.balls==0 && this.strikes==0){
            System.out.println("낫싱");
        }else if(this.balls==0 && this.strikes!=0){
            System.out.println(this.strikes + "스트라이크");
        }else if(this.balls!=0 && this.strikes==0){
            System.out.println(this.balls + "볼");
        }else{
            System.out.println(this.strikes + "스트라이크 " + this.balls + "볼");
        }
    }

    private boolean containsNumber(int[] numbers, int number) {
        for (int num : numbers) {
            if (num == number) {
                return true;
            }
        }
        return false;
    }

    public int strikeCount(){
        return this.strikes;
    }

}


