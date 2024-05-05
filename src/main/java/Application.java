import common.GameManager;

public class Application {

	public static void main (String[] args) {
		GameManager gm= new GameManager();

		while(!gm.isEnd()){
			gm.run();
		}

	}
}
