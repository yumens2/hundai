public class Validation {

    public void validateNumber(String input) throws IllegalArgumentException{
        if(input.length() != Constant.NUM)
            throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다.");

        int[] check = new int[10];
        for(int i=0;i<Constant.NUM;i++) {
            char ch = input.charAt(i);
            if (ch  <= '0' || ch > '9')
                throw new IllegalArgumentException("정수 이외의 입력은 허용되지 않습니다.");
            if(check[ch - '0']>=1)
                throw new IllegalArgumentException("입력은 서로 다른 정수여야 합니다.");
            else check[ch - '0']++;
        }
    }
    public void validateInt(String num)throws IllegalArgumentException{
        if(!num.equals("1")&&!num.equals("2"))
            throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
    }
}
