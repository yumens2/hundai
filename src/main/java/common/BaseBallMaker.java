package common;

import vo.BaseBallVO;
import java.util.Random;

public class BaseBallMaker {

	private final BaseBallVO randVO;
	private final Random random;

	BaseBallMaker(){
		random = new Random();
		randVO = new BaseBallVO(0,0,0);
		make(); //객체 생성 시 make 하지 않고 쓸 수 있으므로 약간의 overhead를 가지고 사용
	}


	/**
	 * Ball의 값을 랜덤한 값으로 설정
	 */
	public void make(){
		randVO.reset(getRandomValue(),getRandomValue(),getRandomValue());
	}

	/**
	 * 랜덤한 값을 생성한다.
	 * @return 1<=return<=9
	 */
	protected int getRandomValue(){
		return random.nextInt(1,10);
	}
}
