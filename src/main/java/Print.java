class Print{
    //결과값 프린트
    void result(int ba ,int st) {
        if(ba!= 0 && st!= 0) {
            System.out.println(ba+ "볼 "+st+ "스트라이크" );
        }
        else if(st!= 0 && ba==0) {
            System.out.println(st+ "스트라이크");
        }
        else if(ba!= 0 && st==0) {
            System.out.println(ba+ "볼");
        }
        else
            System.out.println("낫싱");

    }
}