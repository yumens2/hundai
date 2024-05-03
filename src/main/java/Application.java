package main.java;
public class Application{
    public static void main(String[] args) throws Exception {
        boolean FLAGNUM=true;
        while(FLAGNUM){
            Number num=new Number();
            num.chkEquality();
            FLAGNUM=num.FLAG;
        }
    }
}