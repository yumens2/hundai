public class BaseBallBE {
    public static void main(String[] args) {
        int[] cpunum = new int[3];
        int[] playernum = new int[3];
        int[] strikeballcount = new int[2];
        Computer cpu = new Computer();
        Player ply = new Player();
        StrikeBallChecking sbc = new StrikeBallChecking();
        cpu.RandomThreeNumber(cpunum);
        for(int i = 0; i < cpunum.length; i++){
            System.out.print(cpunum[i]);
        }
        while(strikeballcount[0] != 3){
            try {
                ply.inputplayernum(playernum);
            }catch(IllegalArgumentException e){
                System.out.println(e.toString());
            }
            for(int i = 0; i < playernum.length; i++){
                System.out.println(playernum[i]);
            }
            sbc.countStrikeBall(cpunum,playernum, strikeballcount);
            sbc.outputresult(strikeballcount);
        }
        if(strikeballcount[0] == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}
