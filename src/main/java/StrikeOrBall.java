public class StrikeOrBall {
    int num1;
    int num2;

    StrikeOrBall(){
        num1=0;
        num2=0;
    }
    //위치랑 숫자 모두 같을 경우 strike
    public int strike(int[] arr1, int[] arr2){
        if (arr1[0]==arr2[0]) {
            num1++;
        }
        if (arr1[1]==arr2[1]) {
            num1++;
        }
        if (arr1[2]==arr2[2]) {
            num1++;
        }
        return num1;
    }

    //숫자만 같을 경우 ball
    public int ball(int[] arr1, int[] arr2){
        if (arr1[0]==arr2[0] || arr1[0]==arr2[1] || arr1[0]==arr2[2]) {
            num2++;
        }
        if (arr1[1]==arr2[0] || arr1[1]==arr2[1] || arr1[1]==arr2[2]) {
            num2++;
        }
        if (arr1[2]==arr2[0] || arr1[2]==arr2[1] || arr1[2]==arr2[2]) {
            num2++;
        }
        return num2;
    }
}
