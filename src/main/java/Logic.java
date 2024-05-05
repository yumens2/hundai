public class Logic {
    public static int judgment_strike(int answer, int input) {
        int hundred_a, ten_a, one_a;
        int hundred_i, ten_i, one_i;
        int strike = 0;
      
        hundred_a = answer / 100;
        ten_a = (answer%100) / 10;
        one_a = (answer%10);
      
        hundred_i = input / 100;
        ten_i = (input%100) / 10;
        one_i = (input%10);
       //숫자가 같고 위치도 같으면 스트라이크
       //숫자가 같고 위치가 다르면 볼
       //숫자가 다르고 위치가 다르면 낫싱
        if(hundred_a == hundred_i)
          strike++;
        if(ten_a == ten_i)
          strike++;    
        if(one_a == one_i)
          strike++;
      
        return strike;
      }

      public static int judgment_ball(int answer, int input) {
        int hundred_a, ten_a, one_a;
        int hundred_i, ten_i, one_i;
        int ball = 0;
      
        hundred_a = answer / 100;
        ten_a = (answer%100) / 10;
        one_a = (answer%10);
      
        hundred_i = input / 100;
        ten_i = (input%100) / 10;
        one_i = (input%10);
       //숫자가 같고 위치도 같으면 스트라이크
       //숫자가 같고 위치가 다르면 볼
       //숫자가 다르고 위치가 다르면 아무것도 아닌거임
        if(hundred_a==ten_i)
          ball++;
        if(hundred_a==one_i)
          ball++;
        if(ten_a==hundred_i)
          ball++;
        if(ten_a==one_i)
          ball++;
        if(one_a==hundred_i)
          ball++;
        if(one_a==ten_i)
          ball++;
      
      
        return ball;
      }
}
