public class Application {
    public static void main(String[] args) {

        Randomint rd= new Randomint();
        int[] arr1= new int[3];
        rd.randint(arr1);

        int[] arr2= new int[3];
        rd.myint(arr2);

        StrikeOrBall sb= new StrikeOrBall();

        int st= sb.strike(arr1, arr2);
        int ba= sb.ball(arr1, arr2);
        ba= ba- st; //ball과 strike가 중복되지 않도록 계산
    }
}