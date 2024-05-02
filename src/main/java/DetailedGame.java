public class DetailedGame {
    public void play(){
        int[] cpunum = new int[3];
        int[] playernum = new int[3];
        int[] strikeballcount = new int[2];
        Computer cpu = new Computer();
        Player ply = new Player();
        StrikeBallChecking sbc = new StrikeBallChecking();
        cpu.RandomThreeNumber(cpunum);
        while(strikeballcount[0] != 3){
            try {
                ply.inputplayernum(playernum);
            }catch(IllegalArgumentException e){
                System.out.println(e.toString());
                System.exit(0);
            }
            sbc.countStrikeBall(cpunum,playernum, strikeballcount);
            sbc.outputresult(strikeballcount);
        }
        if(strikeballcount[0] == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

}
