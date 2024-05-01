public class Validation {

    public void validateNumber(String input) throws IllegalArgumentException{
        if(input.length() != Constant.NUM)
            throw new IllegalArgumentException("You must enter a 3-digit number.");

        int[] check = new int[10];
        for(int i=0;i<Constant.NUM;i++) {
            char ch = input.charAt(i);
            if (ch  <= '0' || ch > '9')
                throw new IllegalArgumentException("Input other than integers is not allowed.");
            if(check[ch - '0']>=1)
                throw new IllegalArgumentException("The inputs must be different integers.");
            else check[ch - '0']++;
        }
    }
    public void validateInt(String num)throws IllegalArgumentException{
        if(!num.equals("1")&&!num.equals("2"))
            throw new IllegalArgumentException("You must enter 1 or 2.");
    }
}
