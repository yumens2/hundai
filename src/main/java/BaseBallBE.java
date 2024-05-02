public class BaseBallBE {
    public static void main(String[] args) {
        boolean gamestatus = true;
        int continuenum = 0;
        while(gamestatus){
            DetailedGame dg = new DetailedGame();
            ContinueGame cg = new ContinueGame();
            dg.play();
            try{
                continuenum = cg.continueorexit();
            }catch(IllegalArgumentException e){
                System.out.println(e.toString());
            }
            if(continuenum == 1){
                gamestatus = true;
            }else if(continuenum == 2){
                gamestatus = false;
            }
        }
    }
}
