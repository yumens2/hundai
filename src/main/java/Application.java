public class Application{
    public static void main(String[] args) throws Exception {
        boolean FLAG_NUM=true;
        while(FLAG_NUM){
            Number num=new Number();
            num.chkEquality();
            FLAG_NUM=num.FLAG;
        }
    }
}