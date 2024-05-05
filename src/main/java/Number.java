import java.util.Scanner;
public class Number{
    boolean FLAG;
    int[] RANDOM_NUM=new int[3];
    int MY_NUM;
    int BALL;
    int STRIKE;
    public Number() {
        FLAG=true;
        BALL=0; STRIKE=0;
        RANDOM_NUM[0]=(int)(10*Math.random());
        while(true){
            RANDOM_NUM[1]=(int)(10*Math.random());
            if(RANDOM_NUM[0]!=RANDOM_NUM[1]) break;
        }
        while(true){
            RANDOM_NUM[2]=(int)(10*Math.random());
            if(RANDOM_NUM[0]!=RANDOM_NUM[2]&&RANDOM_NUM[1]!=RANDOM_NUM[2]) break;
        }
    }
    public void getNum() throws Exception{
        BALL=0; STRIKE=0;
        System.out.print("숫자를 입력해 주세요 : ");
        Scanner sc=new Scanner(System.in);
        String S=sc.next();
        if(S.length()!= 3) {
            throw new Exception("IllegalArgumentException");
        }
        else {
            if(!isNumeric(S)) {
                throw new Exception("IllegalArgumentException");
            }
            int TEMP=Integer.parseInt(S);
            isNumOk(TEMP);
        }
    }
    private static boolean isNumeric(String str){
        return str != null && str.matches("[0-9.]+");
    }
    public void isNumOk(int NUM) throws Exception{
        if(NUM<0||NUM>999)
            throw new Exception("IllegalArgumentException");
        MY_NUM=NUM;
    }
    public void compareNum(){
        if(!FLAG)
            return;
        int TMP=MY_NUM;
        int[] A=new int[3];
        A[0]=TMP/100;
        TMP%=100;
        A[1]=TMP/10;
        TMP%=10;
        A[2]=TMP;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                isEqualNum(i,j,A[j],RANDOM_NUM[i]);
            }
        }
        printWhat();
    }
    public void isEqualNum(int i, int j, int a,int r){
        if(a==r){
            if(i==j){
                STRIKE++;
            }
            else{
                BALL++;
            }
        }
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
            compareNum();
            if(STRIKE==3) {
                finishedGame();
                return;
            }
            FLAG_NUM1=FLAG;
        }
    }
}