public class BaseballVO {

    private int score=0;
    private int[] player_array = new int[3];
    private int[] random_array = new int[3];
    private int player_number;
    private int random_number;
    private int ball=0;
    private int strike=0;


    public BaseballVO(int player_number, int random_number) {
        this.player_number = player_number;
        this.random_number = random_number;
    }// constructor end


    public void make_array(){
        for (int i=0; i<3; i++){
            player_array[i]=player_number%10;
            random_array[i] = random_number%10;
            player_number=player_number/10;
            random_number = random_number/10;
        }
    }// 입력받은 숫자를 각 배열에 넣어줍니다.


    public void compare(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                add_strike(player_array[i] , random_array[j] , i ,j);
            }
        }
    }// 인덱스랑 값이랑 비교해서 볼카운트 메서드를 불러들입니다.


    public void add_strike(int player, int random, int player_index, int random_index) {
        if ( player==random) {
            if (player_index== random_index) {
                strike += 1;
            }
            else {
                ball += 1;
            }
        }
    }// 조건이 일치할때 볼카운트를 올립니다.


    public int set_answer(){
        return strike*100+ball*10;
    }// 스트라이크/볼/아웃 순서로 3자리 정수를 만들어 출력합니다.


    public void print_answer(){
        if (ball !=0){
            System.out.print(ball+"ball  ");
        }
        if (strike !=0){
            System.out.print(strike+"strike  ");
        }
        if (strike==0 & ball==0){
            System.out.print("Nothing");
        }
        System.out.println(" ");
    }// 각 볼카운트가 0이 아닐때만 측정해줍니다


}
