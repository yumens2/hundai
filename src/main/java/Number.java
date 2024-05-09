import java.util.Random;
import java.util.Scanner;

public class Number{
    boolean FLAG;
    String USER_NUMBER;
    int[] RANDOM_NUM=new int[3];
    int[] MY_NUM=new int[3];
    int BALL;
    int STRIKE;
    public Number() {
        FLAG=true;
        BALL=0; STRIKE=0;
        RANDOM_NUM[0]=(int)(10*Math.random());
        do{
            RANDOM_NUM[1]=(int)(10*Math.random());
        }while(RANDOM_NUM[0]==RANDOM_NUM[1]);
        do{
            RANDOM_NUM[2]=(int)(10*Math.random());
        }while(RANDOM_NUM[0]==RANDOM_NUM[2]||RANDOM_NUM[1]==RANDOM_NUM[2]);
        /*System.out.println(RANDOM_NUM[0]);
        System.out.println(RANDOM_NUM[1]);
        System.out.println(RANDOM_NUM[2]);*/
    }
    public void inputNum(){
        System.out.print("숫자를 입력해 주세요 : ");
        Scanner sc=new Scanner(System.in);
        USER_NUMBER=sc.next();
    }
    public void getNum() throws Exception{
        BALL=0; STRIKE=0;
        inputNum();
        if(USER_NUMBER.length()!= 3) {
            throw new Exception("IllegalArgumentException");
        }
        if(!isNumeric(USER_NUMBER)) {
            throw new Exception("IllegalArgumentException");
        }
        int TEMP = Integer.parseInt(USER_NUMBER);
        isNumOk(TEMP);
    }
    private static boolean isNumeric(String str){
        return str != null && str.matches("[0-9.]+");
    }
    public void isNumOk(int NUM) throws Exception{
        if(NUM<0||NUM>999){
            throw new Exception("IllegalArgumentException");
        }
        int GET_NUM=NUM;
        MY_NUM[0]=GET_NUM/100;
        GET_NUM%=100;
        MY_NUM[1]=GET_NUM/10;
        GET_NUM%=10;
        MY_NUM[2]=GET_NUM;
        if(MY_NUM[0]==MY_NUM[1]||MY_NUM[0]==MY_NUM[2]||MY_NUM[1]==MY_NUM[2])
            throw new Exception("IllegalArgumentException");
    }
    public void compareNum(){
        if(!FLAG) return;
        int[] COUNT_INDEXES_I= {0,0,0,1,1,1,2,2,2};
        int[] COUNT_INDEXES_J= {0,1,2,0,1,2,0,1,2};
        for(int i=0;i<9;i++){
            int x=COUNT_INDEXES_I[i];
            int y=COUNT_INDEXES_J[i];
//            System.out.println(MY_NUM[y]);
//            System.out.println(RANDOM_NUM[x]);
            isEqualNum(x,y,MY_NUM[y],RANDOM_NUM[x]);
        }
        printWhat();
    }
    public void isEqualNum(int i, int j, int a,int r){
        if(a!=r) return;
        if(i==j){
            STRIKE++;
            return;
        }
        BALL++;
    }
    public void printWhat(){
        if(BALL==0&&STRIKE==0)
            System.out.println("낫싱");
        else if(BALL==0&&STRIKE>0)
            System.out.println(STRIKE+"스트라이크");
        else if(BALL>0&&STRIKE==0)
            System.out.println(BALL+"볼");
        else System.out.println(BALL+"볼 "+STRIKE+"스트라이크");
    }
    public void chkEquality() throws Exception {
        boolean FLAG_NUM1=true;
        while(FLAG_NUM1){
            getNum();
            if(!FLAG) break;
            compareNum();
            if(!FLAG) break;
            if(STRIKE==3) {
                finishedGame();
                return;
            }
            FLAG_NUM1=FLAG;
        }
    }
    public void finishedGame() throws Exception{
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner sc=new Scanner(System.in);
        String S=sc.next();
        int GET_NUM=Integer.parseInt(S);
        if(GET_NUM==1) return;
        if(GET_NUM==2){
            FLAG=false;
            return;
        }
        throw new Exception("IllegalArgumentException");
    }
}
